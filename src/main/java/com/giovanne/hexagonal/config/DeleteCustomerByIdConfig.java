package com.giovanne.hexagonal.config;

import com.giovanne.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.giovanne.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.giovanne.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {


    @Bean
    DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                        DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
