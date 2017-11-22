package com.demo.microarch.config.intercomm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;

@Configuration
public class FeignConfigure {
	public static int connectTimeOutMillis = 120000;
    public static int readTimeOutMillis = 120000;
    @Bean
    public Request.Options options() {
           return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }
}
