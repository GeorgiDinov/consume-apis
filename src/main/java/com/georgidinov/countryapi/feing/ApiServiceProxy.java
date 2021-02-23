package com.georgidinov.countryapi.feing;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "countries-api", url = "${countries.rest.url}")
public interface ApiServiceProxy extends ApiService {

}