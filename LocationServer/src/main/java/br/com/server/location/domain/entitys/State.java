package br.com.server.location.domain.entitys;

import br.com.server.location.domain.entitys.builders.StateBuilder;

import java.io.Serializable;
import java.util.List;

public class State implements Serializable {

    private String name;

    private String initials;

    private Country country;

    private List<City> cities;

    public static StateBuilder builder() {
        return StateBuilder.getInstance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

}