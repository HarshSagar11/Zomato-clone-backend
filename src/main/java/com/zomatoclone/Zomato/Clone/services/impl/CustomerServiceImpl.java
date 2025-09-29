package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.entities.Customer;
import com.zomatoclone.Zomato.Clone.entities.User;
import com.zomatoclone.Zomato.Clone.repositories.CustomerRepository;
import com.zomatoclone.Zomato.Clone.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void createCustomerFromUser(User user) {
        Customer customer = new Customer();
        customer.setUser(user);
        customer.setRating(0d);
        customerRepository.save(customer);
    }
}
