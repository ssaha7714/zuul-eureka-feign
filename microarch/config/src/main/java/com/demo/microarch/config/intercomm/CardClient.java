package com.demo.microarch.config.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.microarch.config.model.Card;

@FeignClient(value="card", configuration=FeignConfigure.class)
public interface CardClient {

    @RequestMapping(method = RequestMethod.GET, value = "/cards/customer/{x}")
    List<Card> getCards(@PathVariable("x") Integer customerId);
    
}
