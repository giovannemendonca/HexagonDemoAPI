package com.giovanne.hexagonal.application.ports.out;

import com.giovanne.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> findById(String id);
}
