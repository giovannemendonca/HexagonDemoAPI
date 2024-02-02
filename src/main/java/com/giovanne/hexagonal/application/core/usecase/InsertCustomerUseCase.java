package com.giovanne.hexagonal.application.core.usecase;

import com.giovanne.hexagonal.application.core.domain.Customer;
import com.giovanne.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.giovanne.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.giovanne.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.giovanne.hexagonal.application.ports.out.SendCpfForValidateOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidateOutputPort sendCpfForValidateOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidateOutputPort sendCpfForValidateOutputPort
                                 ) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidateOutputPort = sendCpfForValidateOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidateOutputPort.send(customer.getCpf());
    }
}
