package com.georgidinov.countryapi.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RestTemplateCountryApiConsumer {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateCountryApiConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/template/countries")
    public List<Object> fetchCountries() {
        String countriesUrl = "https://restcountries.eu/rest/v2/all";
        Object[] countriesData = this.restTemplate.getForObject(countriesUrl, Object[].class);
        if (countriesData == null) {
            System.out.println("No Data");
            return new ArrayList<>();
        }
        return Arrays.asList(countriesData);
    }

}