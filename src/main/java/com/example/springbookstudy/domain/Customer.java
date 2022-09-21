package com.example.springbookstudy.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class  Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false,name ="FIRST_NAME")
    private String firstName;
    @Column(nullable=false,name = "LAST_NAME")
    private String lastName;
}
