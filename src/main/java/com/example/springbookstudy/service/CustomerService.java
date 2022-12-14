package com.example.springbookstudy.service;

import com.example.springbookstudy.domain.Customer;
import com.example.springbookstudy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAllOrderByName();
    }

    public Customer findOne(Integer id){
        return customerRepository.findById(id).get();
    }

    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer){
       return  customerRepository.save(customer);
    }

    public void delete(Integer id){
        customerRepository.deleteById(id);
    }
}
