package com.giovanne.hexagonal.application.ports.out;

import com.giovanne.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
