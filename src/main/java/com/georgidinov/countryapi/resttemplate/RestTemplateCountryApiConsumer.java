package com.georgidinov.countryapi.resttemplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.georgidinov.util.ApplicationConstants.ALL_COUNTRIES_URL;
import static com.georgidinov.util.ApplicationConstants.ONE_COUNTRY_URL;

@RestController
public class RestTemplateCountryApiConsumer {


    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateCountryApiConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/template/countries")
    public List<Object> fetchCountries() {
        Object[] countriesData = this.restTemplate.getForObject(ALL_COUNTRIES_URL, Object[].class);
        if (countriesData == null) {
            System.out.println("No Data");
            return new ArrayList<>();
        }
        return Arrays.asList(countriesData);
    }

    @GetMapping("/template/countries/{countryName}")
    public Object fetchCountryByName(@PathVariable String countryName) {
        return this.restTemplate.getForObject(ONE_COUNTRY_URL + "/" + countryName, Object.class);
    }

}