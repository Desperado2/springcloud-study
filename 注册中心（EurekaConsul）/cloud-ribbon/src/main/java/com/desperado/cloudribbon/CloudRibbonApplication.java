package com.desperado.cloudribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class CloudRibbonApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    };

    @GetMapping("/ribbon")
    public String findHelloByEmail(String email) {
        // VIP模式，不需要填写 IP+端口 Ribbon会去注册中心获取当前可用服务然后做HTTP请求
        return "server  <<==>>  "+restTemplate().getForObject("http://cloud-discovery-client-consul/hello?email="+email,String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudRibbonApplication.class, args);
    }

}

