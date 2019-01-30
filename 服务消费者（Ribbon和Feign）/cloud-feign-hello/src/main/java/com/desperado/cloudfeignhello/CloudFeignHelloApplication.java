package com.desperado.cloudfeignhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudFeignHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudFeignHelloApplication.class, args);
    }

}

