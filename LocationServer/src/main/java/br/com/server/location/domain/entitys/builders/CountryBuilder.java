package br.com.server.location.domain.entitys.builders;

import br.com.server.location.domain.entitys.Country;
import br.com.server.location.domain.entitys.State;

import java.util.List;

public final class CountryBuilder {

    private Country country;

    private CountryBuilder() {
        country = new Country();
    }

    public static CountryBuilder getInstance() {
        return new CountryBuilder();
    }

    public CountryBuilder name(String name) {
        country.setName(name);
        return this;
    }

    public CountryBuilder states(List<State> states) {
        country.setStates(states);
        return this;
    }

    public Country build() {
        return country;
    }

}