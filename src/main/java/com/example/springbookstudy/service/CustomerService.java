package com.example.springbookstudy.service;

import com.example.springbookstudy.domain.Customer;
import com.example.springbookstudy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    //그 외의 메서드 3장에서 정의

}
