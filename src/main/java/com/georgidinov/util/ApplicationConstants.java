package com.georgidinov.util;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public final class ApplicationConstants {

    public static final Path TOKEN_PATH = FileSystems.getDefault().getPath("Token/token.txt");

    public static final String COUNTRIES_BASE_URL = "https://restcountries.eu";
    public static final String ALL_COUNTRIES_URL = COUNTRIES_BASE_URL + "/rest/v2/all";
    public static final String ONE_COUNTRY_URL = COUNTRIES_BASE_URL + "/rest/v2/name";


    public static final String MY_API_AUTHENTICATION_URL = "http://localhost:8080/login";
    public static final String MY_API_ALL_MARKS_URL = "http://localhost:8080/api/v1/mark";
    public static final String MY_API_ALL_STUDENTS_URL = "http://localhost:8080/api/v1/student";

    //== constructors ==
    private ApplicationConstants() {
    }
}