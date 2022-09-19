package com.example.springbookstudy;

import com.example.springbookstudy.domain.Customer;
import com.example.springbookstudy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {


        //데이터 추가..
        Customer created = customerRepository.save(
                new Customer(null, "Hidetoshi", "Dekisugi"));
        System.out.println(created + "is created\n\n");

        //데이터 표시
        customerRepository.findAllOrderByName().forEach(System.out::println);

    }
        public static void main(String[] args) {
        SpringApplication.run(App.class, args);

}}
