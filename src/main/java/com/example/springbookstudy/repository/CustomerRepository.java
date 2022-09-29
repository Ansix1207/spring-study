package com.example.springbookstudy.repository;

import com.example.springbookstudy.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT x from Customer x ORDER BY x.firstName, x.lastName")
    List<Customer> findAllOrderByName();
}