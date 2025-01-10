package dev.alejandro.cloudgateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class CloudGatewayApplication {

    private static final Logger log = LoggerFactory.getLogger(CloudGatewayApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(@Value("${spring.zipkin.base-url}") String zipkinUrl) {
        return args -> {
            log.info("Zipkin URL:{} ",zipkinUrl);
        };
    }

}
