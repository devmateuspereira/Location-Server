package br.com.server.location.domain.entitys.builders;

import br.com.server.location.domain.entitys.City;
import br.com.server.location.domain.entitys.Country;
import br.com.server.location.domain.entitys.State;

import java.util.List;

public final class StateBuilder {

    private State state;

    private StateBuilder() {
        state = new State();
    }

    public static StateBuilder getInstance() {
        return new StateBuilder();
    }

    public StateBuilder name(String name) {
        state.setName(name);
        return this;
    }

    public StateBuilder initials(String initials) {
        state.setInitials(initials);
        return this;
    }

    public StateBuilder country(Country country) {
        state.setCountry(country);
        return this;
    }

    public StateBuilder cities(List<City> cities) {
        state.setCities(cities);
        return this;
    }

    public State build() {
        return state;
    }

}