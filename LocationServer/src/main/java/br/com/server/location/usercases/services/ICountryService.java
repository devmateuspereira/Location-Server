package br.com.server.location.usercases.services;

import br.com.server.location.domain.entitys.Country;
import br.com.server.location.usercases.exceptions.NoRecordFoundException;
import br.com.server.location.usercases.exceptions.ValidationFieldException;

import java.util.List;

public interface ICountryService {

    public List<Country> searchAllCountries() throws NoRecordFoundException;

    public void deleteCountry(String countryName) throws ValidationFieldException, NoRecordFoundException;

    public Country registerCountry(Country country) throws ValidationFieldException;

    public Country searchByName(String countryName) throws NoRecordFoundException;

}