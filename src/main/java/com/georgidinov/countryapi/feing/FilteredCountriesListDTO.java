package com.georgidinov.countryapi.feing;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FilteredCountriesListDTO {

    //== fields ==
    @JsonProperty("countries")
    List<FilteredCountryDTO> countries;

    public FilteredCountriesListDTO() {
    }

    public FilteredCountriesListDTO(List<FilteredCountryDTO> countries) {
        this.countries = countries;
    }

    public List<FilteredCountryDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<FilteredCountryDTO> countries) {
        this.countries = countries;
    }
}