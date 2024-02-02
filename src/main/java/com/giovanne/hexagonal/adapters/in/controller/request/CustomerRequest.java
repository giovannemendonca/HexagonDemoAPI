package com.giovanne.hexagonal.adapters.in.controller.request;

import com.giovanne.hexagonal.application.core.domain.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String zipCode;

}
