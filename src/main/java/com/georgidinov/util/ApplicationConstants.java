package com.georgidinov.util;

public final class ApplicationConstants {

    public static final String COUNTRIES_BASE_URL = "https://restcountries.eu";
    public static final String ALL_COUNTRIES_URL = COUNTRIES_BASE_URL + "/rest/v2/all";
    public static final String ONE_COUNTRY_URL = COUNTRIES_BASE_URL + "/rest/v2/name";


    public static final String MY_API_AUTHENTICATION_URL = "http://localhost:8080/login";

    //== constructors ==
    private ApplicationConstants() {
    }
}