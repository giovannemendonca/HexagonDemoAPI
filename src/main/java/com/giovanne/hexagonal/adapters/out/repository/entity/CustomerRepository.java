package com.giovanne.hexagonal.adapters.out.repository.entity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String>{
}
