package com.all_in_one_springdata.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan
@EnableJpaRepositories
public class SpringdataApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringdataApplication.class, args);


    }


}
