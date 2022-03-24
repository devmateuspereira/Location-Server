package br.com.server.location.domain.entitys;

import br.com.server.location.domain.entitys.builders.CountryBuilder;

import java.io.Serializable;
import java.util.List;

public class Country implements Serializable {

    private String name;

    private List<State> states;

    public static CountryBuilder builder() {
        return CountryBuilder.getInstance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

}