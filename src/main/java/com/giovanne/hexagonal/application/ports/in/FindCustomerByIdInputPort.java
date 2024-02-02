package com.giovanne.hexagonal.application.ports.in;

import com.giovanne.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
