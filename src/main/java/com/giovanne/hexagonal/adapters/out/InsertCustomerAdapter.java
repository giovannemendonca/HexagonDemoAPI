package com.giovanne.hexagonal.adapters.out;

import com.giovanne.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.giovanne.hexagonal.adapters.out.repository.entity.CustomerRepository;
import com.giovanne.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.giovanne.hexagonal.application.core.domain.Customer;
import com.giovanne.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
