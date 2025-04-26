package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SalutationAmicale extends SalutationBase implements InitializingBean, DisposableBean {

    private DataBaseConfiguration dataBaseConfiguration;

    public SalutationAmicale(DataBaseConfiguration dataBaseConfiguration) {
        this.dataBaseConfiguration = dataBaseConfiguration;
    }

    @Override
    public String saluer() {
        return "Bonjour Amicale ... " + compteur++ +" "+ dataBaseConfiguration.getUrl()+" "+dataBaseConfiguration.getUserName();
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        System.out.println("after property set");
    }

    @Override
    public void destroy() throws Exception{
        System.out.println("destroy");
    }
    @PostConstruct
    private void postconstruct(){
        System.out.println("post construct");
    }

    @PreDestroy
    private void predestroy(){
        System.out.println("pre destroy");
    }
}