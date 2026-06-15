package com.cib.customer.service;

import com.cib.customer.dto.CustomerRequest;
import com.cib.customer.entity.Customer;
import com.cib.customer.exception.CustomerNotFoundException;
import com.cib.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(CustomerRequest request) {

        Customer customer = new Customer();

        customer.setCustomerId(
                "CUST-" + System.currentTimeMillis());

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setMobile(request.getMobile());
        customer.setAddress(request.getAddress());

        customer.setCustomerStatus("ACTIVE");
        customer.setKycStatus("PENDING");

        return customerRepository.save(customer);
    }

    public Customer getByCustomerId(String customerId) {

        return customerRepository
                .findByCustomerId(customerId)
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer Not Found : " + customerId));
    }

    public Customer verifyKyc(String customerId) {

        Customer customer = getByCustomerId(customerId);

        customer.setKycStatus("VERIFIED");

        return customerRepository.save(customer);
    }

    public Customer blockCustomer(String customerId) {

        Customer customer = getByCustomerId(customerId);

        customer.setCustomerStatus("BLOCKED");

        return customerRepository.save(customer);
    }

    public Customer activateCustomer(String customerId) {

        Customer customer = getByCustomerId(customerId);

        customer.setCustomerStatus("ACTIVE");

        return customerRepository.save(customer);
    }
}