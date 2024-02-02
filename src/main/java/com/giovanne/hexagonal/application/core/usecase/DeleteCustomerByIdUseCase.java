package com.giovanne.hexagonal.application.core.usecase;

import com.giovanne.hexagonal.application.core.domain.Customer;
import com.giovanne.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.giovanne.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.giovanne.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id) {
        Customer customer = findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(customer.getId());
    }

}
