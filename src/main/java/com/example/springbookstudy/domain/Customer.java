package com.example.springbookstudy.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  Customer {

    private Integer id;
    private String firstName;
    private String lastName;
}
