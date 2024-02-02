package com.giovanne.hexagonal.config;

import com.giovanne.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.giovanne.hexagonal.adapters.out.InsertCustomerAdapter;
import com.giovanne.hexagonal.adapters.out.SendCpfValidateAdapter;
import com.giovanne.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       InsertCustomerAdapter insertCustomerAdapter,
                                                       SendCpfValidateAdapter sendCpfValidateAdapter
                                                       ) {

        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidateAdapter);
    }
}
