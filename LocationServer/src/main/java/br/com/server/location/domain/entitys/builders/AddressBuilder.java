package br.com.server.location.domain.entitys.builders;

import br.com.server.location.domain.entitys.Address;
import br.com.server.location.domain.entitys.City;

public final class AddressBuilder {

    private Address address;

    private AddressBuilder() {
        address = new Address();
    }

    public static AddressBuilder getInstance() {
        return new AddressBuilder();
    }

    public AddressBuilder number(Integer number) {
        address.setNumber(number);
        return this;
    }

    public AddressBuilder zipCod(String zipCod) {
        address.setZipCod(zipCod);
        return this;
    }

    public AddressBuilder street(String street) {
        address.setStreet(street);
        return this;
    }

    public AddressBuilder district(String district) {
        address.setDistrict(district);
        return this;
    }

    public AddressBuilder complement(String complement) {
        address.setComplement(complement);
        return this;
    }

    public AddressBuilder city(City city) {
        address.setCity(city);
        return this;
    }

    public Address build() {
        return address;
    }

}