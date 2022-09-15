package com.example.springbookstudy;

import com.example.springbookstudy.domain.Customer;
import com.example.springbookstudy.repository.CustomerRepository;
import com.example.springbookstudy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {

        //데이터 표시
        customerRepository.findAll().forEach(System.out::println);
        //데이터 추가..
        Customer created = customerRepository.save(new Customer(1, "Hidetoshi", "Dekisugi"));
        System.out.println(created + "is created\n\n");

        customerRepository.findAll().forEach(System.out::println);

    }
        public static void main(String[] args) {
        SpringApplication.run(App.class, args);

}}
