package com.giovanne.hexagonal.adapters.out;

import com.giovanne.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.giovanne.hexagonal.adapters.out.repository.entity.CustomerRepository;
import com.giovanne.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.giovanne.hexagonal.application.core.domain.Customer;
import com.giovanne.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> findById(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
