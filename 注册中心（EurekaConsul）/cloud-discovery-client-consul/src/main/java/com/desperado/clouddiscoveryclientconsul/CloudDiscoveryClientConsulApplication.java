package com.desperado.clouddiscoveryclientconsul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class CloudDiscoveryClientConsulApplication {

    @Value("${spring.application.name}")
    String applicationName;

    @RequestMapping("/hello")
    public String home(@RequestParam String email) {
        return "My Name's :" + applicationName + " Email:" + email;
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudDiscoveryClientConsulApplication.class, args);
    }

}

