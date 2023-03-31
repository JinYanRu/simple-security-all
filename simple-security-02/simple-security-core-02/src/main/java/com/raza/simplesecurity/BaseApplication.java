package com.raza.simplesecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.IOException;

/**
 * to do
 *
 * @author Raza
 * @date 2023/3/29
 */
@SpringBootApplication
//@ServletComponentScan
public class BaseApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(BaseApplication.class, args);
    }
}

