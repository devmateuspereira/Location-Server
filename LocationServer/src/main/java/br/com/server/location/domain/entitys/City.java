package br.com.server.location.domain.entitys;

import br.com.server.location.domain.entitys.builders.CityBuilder;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {

    private String name;

    private State state;

    private List<Address> addresses;

    public static CityBuilder builder() {
        return CityBuilder.getInstance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}