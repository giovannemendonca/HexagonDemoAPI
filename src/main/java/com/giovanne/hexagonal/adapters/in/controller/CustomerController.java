package com.giovanne.hexagonal.adapters.in.controller;

import com.giovanne.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.giovanne.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.giovanne.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.giovanne.hexagonal.application.core.domain.Customer;
import com.giovanne.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.giovanne.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.giovanne.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.giovanne.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        Customer customer = findCustomerByIdInputPort.find(id);
        CustomerResponse response = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {

        Customer customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
