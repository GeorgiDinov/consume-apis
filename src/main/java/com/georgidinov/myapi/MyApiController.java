package com.georgidinov.myapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyApiController {


    //== fields ==
    private final RestTemplate restTemplate;

    @Autowired
    public MyApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}