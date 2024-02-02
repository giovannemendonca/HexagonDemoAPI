package com.giovanne.hexagonal.adapters.in.consumer;

import com.giovanne.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.giovanne.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.giovanne.hexagonal.application.core.domain.Customer;
import com.giovanne.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "mendonca")
    public void receive(CustomerMessage customerMessage) {

        Customer customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
