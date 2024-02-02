package com.giovanne.hexagonal.adapters.out.client;

import com.giovanne.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressZipCodeClient",
        url = "${mendonca.client.address.url}"
)
public interface FindAddressZipCodeClient {

    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable("zipCode") String zipCode);
}
