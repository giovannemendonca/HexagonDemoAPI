package com.giovanne.hexagonal.adapters.in.controller.response;

import com.giovanne.hexagonal.adapters.out.client.response.AddressResponse;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;

    private String cpf;

    private AddressResponse address;

    private String isValidCpf;
}
