package com.coe.sidecar;

import com.oracle.tools.packager.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableSidecar
@RestController
public class SidecarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SidecarApplication.class, args);
    }

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("/hi")
    public String hello() {

        // Eureka서버에서 node-service의 서버정보를 가져온다.
        ServiceInstance serviceInstance = loadBalancerClient.choose("node-service");

        String hostName = serviceInstance.getHost();    // localhost
        int port = serviceInstance.getPort();           // 8008

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://" + hostName + ":" + port + "/hello", String.class);
    }
}
