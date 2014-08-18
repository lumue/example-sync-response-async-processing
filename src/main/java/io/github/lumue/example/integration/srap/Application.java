package io.github.lumue.example.integration.srap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement
@ImportResource("integration-context.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
