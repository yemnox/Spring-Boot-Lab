package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.xml.crypto.Data;

@Configuration
public class SalutationConfiguration {
    @Autowired
    DataBaseConfiguration dataBaseConfiguration;

    @Bean
    @Scope(value="prototype")
    public Salutation salutation()
    {
        return new Salutation();
    }

    @Bean
    public SalutationAmicale salutationAmicale()
    {
        return new SalutationAmicale(dataBaseConfiguration);
    }
}
