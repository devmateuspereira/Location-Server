package br.com.server.location.domain.entitys;

import br.com.server.location.domain.entitys.builders.AddressBuilder;

import java.io.Serializable;

public class Address implements Serializable {

    private Integer number;

    private String zipCod;

    private String street;

    private String district;

    private String complement;

    private City city;

    public static AddressBuilder builder() {
        return AddressBuilder.getInstance();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getZipCod() {
        return zipCod;
    }

    public void setZipCod(String zipCod) {
        this.zipCod = zipCod;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}