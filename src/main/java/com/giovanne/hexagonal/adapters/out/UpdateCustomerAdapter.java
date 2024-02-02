package com.giovanne.hexagonal.adapters.out;

import com.giovanne.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.giovanne.hexagonal.adapters.out.repository.entity.CustomerRepository;
import com.giovanne.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.giovanne.hexagonal.application.core.domain.Customer;
import com.giovanne.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
