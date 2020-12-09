package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = {"com.atguigu.springcloud.dao"})
@SpringBootApplication
public class PaymentMain8001 {


        public static void main(String[] args){
            SpringApplication.run(PaymentMain8001.class, args);
        }

}
