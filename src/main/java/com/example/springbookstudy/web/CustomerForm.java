package com.example.springbookstudy.web;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CustomerForm {
    @NotNull
    @Size(min = 1,max = 127)
    private String firstName;
    @NotNull
    @Size(min = 1,max = 127)
    private String lastName;
}
