package org.mddarr.orders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan(basePackages = "org.mddarr.orders")
public class OrdersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersServiceApplication.class, args);
    }

    private static final Logger logger = LoggerFactory.getLogger(OrdersServiceApplication.class);

    @PostConstruct
    public void postInit() {
        logger.info("Application ShowcaseApp started!");
    }
}
