package com.giovanne.hexagonal.application.core.usecase;

import com.giovanne.hexagonal.application.core.domain.Customer;
import com.giovanne.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.giovanne.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

   public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutputPort.findById(id).orElseThrow(() ->
                new RuntimeException("Customer not found")
        );

    }

}
