package com.georgidinov.countryapi.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.georgidinov.util.ApplicationConstants.ALL_COUNTRIES_URL;
import static com.georgidinov.util.ApplicationConstants.ONE_COUNTRY_URL;


@RestController
public class WebClientCountryApiConsumer {


    private final WebClient.Builder webClientBuilder;

    @Autowired
    public WebClientCountryApiConsumer(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }


    @GetMapping("/webclient/countries")
    public List<Object> getAllCountries() {
        Object[] countriesData = webClientBuilder.codecs(clientCodecConfigurer ->
                clientCodecConfigurer.defaultCodecs().maxInMemorySize(300 * 1024))
                .build()
                .get()
                .uri(ALL_COUNTRIES_URL)
                .retrieve()
                .bodyToMono(Object[].class)
                .block();

        if (countriesData == null) {
            System.out.println("No Data");
            return new ArrayList<>();
        }
        return Arrays.asList(countriesData);

    }

    @GetMapping("/webclient/countries/{countryName}")
    public Object getCountryByName(@PathVariable String countryName) {
        return this.webClientBuilder.build()
                .get()
                .uri(ONE_COUNTRY_URL + "/" + countryName)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }


}