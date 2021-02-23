package com.georgidinov.countryapi.feing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ApiService {

    @GetMapping("/rest/v2/all")
    List<Object> getCountries();

    @GetMapping("/rest/v2/name/{countryName}")
    Object getCountryByName(@PathVariable String countryName);

}