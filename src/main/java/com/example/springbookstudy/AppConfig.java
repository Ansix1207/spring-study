package com.example.springbookstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;

public class AppConfig
{
    @Autowired
    DataSourceProperties dataSourceProperties;
    DataSource dataSource;

    DataSource realDataSource(){
        DataSourceBuilder factory = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.determineUsername())
                .password(this.dataSourceProperties.getPassword());
        this.dataSource=factory.build();
        return this.dataSource;
    }
//    @Bean
//    @Primary
//    DataSource dataSource(){
//        return new Log4JdbcProxyDataSource(this.realDataSource());
//    }


    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    CharacterEncodingFilter characterEncodingFilter(){
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return filter;
    }

}
