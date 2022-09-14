package com.example.springbookstudy.app;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Scanner;
@Component
public class ScArgumentResolver implements ArgumentResolver {

    @Override
    public Argument resolve(InputStream stream) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        return new Argument(a,b);
    }
}
