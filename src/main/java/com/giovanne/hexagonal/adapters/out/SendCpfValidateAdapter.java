package com.giovanne.hexagonal.adapters.out;

import com.giovanne.hexagonal.application.ports.out.SendCpfForValidateOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidateAdapter implements SendCpfForValidateOutputPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}
