package com.giovanne.hexagonal.adapters.out;

import com.giovanne.hexagonal.adapters.out.client.FindAddressZipCodeClient;
import com.giovanne.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.giovanne.hexagonal.adapters.out.client.response.AddressResponse;
import com.giovanne.hexagonal.application.core.domain.Address;
import com.giovanne.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressZipCodeClient findAddressZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = findAddressZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
