package br.com.server.location.domain.entitys.builders;

import br.com.server.location.domain.entitys.Address;
import br.com.server.location.domain.entitys.City;
import br.com.server.location.domain.entitys.State;

import java.util.List;

public final class CityBuilder {

    private City city;

    private CityBuilder() {
        city = new City();
    }

    public static CityBuilder getInstance() {
        return new CityBuilder();
    }

    public CityBuilder name(String name) {
        city.setName(name);
        return this;
    }

    public CityBuilder state(State state) {
        city.setState(state);
        return this;
    }

    public CityBuilder addresses(List<Address> addresses) {
        city.setAddresses(addresses);
        return this;
    }

    public City build() {
        return city;
    }

}