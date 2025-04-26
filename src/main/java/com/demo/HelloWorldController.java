package com.demo;

import com.demo.Salutation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;




@RestController
public class HelloWorldController {
    @Autowired
    Salutation salutation;

    @Autowired
    private SalutationAmicale salutationAmicale;

    @RequestMapping(value="/hello")
    public String hello1()
    {
        return salutation.saluer();
    }

    @RequestMapping(value="/helloAmical")
    public String helloAmical1()
    {
        return salutationAmicale.saluer();
    }

    @RequestMapping
    public String helloWorld(){
        return "Hello World";
    }
}
