package com.georgidinov.countryapi.feing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignCountryApiConsumer implements ApiService {

    //== logger ==
    Logger log = LoggerFactory.getLogger(FeignCountryApiConsumer.class);


    //== fields ==
    private final ApiServiceProxy proxy;

    @Autowired
    public FeignCountryApiConsumer(ApiServiceProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    @GetMapping("/feign/countries")
    public List<Object> getCountries() {
        return proxy.getCountries();
    }

    @Override
    @GetMapping("/feign/countries/{countryName}")
    public Object getCountryByName(@PathVariable String countryName) {
        return proxy.getCountryByName(countryName);
    }


    @GetMapping("/feign/countries/filtered")
    public FilteredCountriesListDTO getCountryList() {
        log.info("FeignCountryApiConsumer::getCountryList");
        return new FilteredCountriesListDTO(this.getCountriesFiltered());
    }

    @Override
    public List<FilteredCountryDTO> getCountriesFiltered() {
        return proxy.getCountriesFiltered();
    }
}