package com.georgidinov.countryapi.feing;

import java.util.Objects;

public class FilteredCountryDTO {

    //== fields ==
    private String flag;
    private String name;
    private String capital;

    //== constructors ==
    public FilteredCountryDTO() {
    }


    //== getters and setters
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FilteredCountryDTO that = (FilteredCountryDTO) o;

        if (!Objects.equals(flag, that.flag)) {
            return false;
        }
        if (!Objects.equals(name, that.name)) {
            return false;
        }
        return Objects.equals(capital, that.capital);
    }

    @Override
    public int hashCode() {
        int result = flag != null ? flag.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FilteredCountryDTO{" +
                " name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}