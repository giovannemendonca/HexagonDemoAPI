package com.giovanne.hexagonal.application.ports.out;

import com.giovanne.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
