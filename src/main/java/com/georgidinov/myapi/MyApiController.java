package com.georgidinov.myapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.georgidinov.myapi.model.AuthenticationRequest;
import com.georgidinov.util.TokenPersistenceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static com.georgidinov.util.ApplicationConstants.MY_API_AUTHENTICATION_URL;

@RestController
public class MyApiController {

    //== logger ==
    Logger log = LoggerFactory.getLogger(MyApiController.class);

    //== fields ==
    private String token;
    private final RestTemplate restTemplate;

    @Autowired
    public MyApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public void authenticate() throws JsonProcessingException {
        log.info("MyApiController::authenticate");
        HttpEntity<String> requestHttpEntity = new HttpEntity<>(authenticationRequestBody(), getHeaders());
        ResponseEntity<Void> authResponse =
                this.restTemplate.exchange(MY_API_AUTHENTICATION_URL, HttpMethod.POST, requestHttpEntity, Void.class);

        if (authResponse.getStatusCode().is2xxSuccessful()) {
            this.token = authResponse.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            log.info("Token extracted = {}", this.token);
            TokenPersistenceManager.writeToken(this.token);
        }
    }

    //== private methods ==
    private String authenticationRequestBody() throws JsonProcessingException {
        String authJson = new AuthenticationRequest("Petey Cruiser2", "password").extractAsJsonString();
        log.info("Authentication JSON = {}", authJson);
        return authJson;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        log.info("Headers Generated = {}", headers.toString());
        return headers;
    }

}