package com.giovanne.hexagonal.adapters.out.client.mapper;


import com.giovanne.hexagonal.adapters.out.client.response.AddressResponse;
import com.giovanne.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
