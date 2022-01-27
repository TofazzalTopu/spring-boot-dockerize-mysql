package com.info.prescription;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEncryptableProperties
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        int a = 1;
        int b = 0;


        SpringApplication.run(DemoApplication.class, args);
    }

}
