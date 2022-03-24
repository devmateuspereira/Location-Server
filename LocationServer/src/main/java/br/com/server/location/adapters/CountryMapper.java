package br.com.server.location.adapters;

import br.com.server.location.controllers.dtos.CountryDTO;
import br.com.server.location.controllers.responses.CountryResponse;
import br.com.server.location.database.entitys.CountryEntity;
import br.com.server.location.domain.entitys.Country;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CountryMapper {

    public static Country convertCountryRequestToCountry(CountryDTO countryRequest) {
        return Country.builder().name(countryRequest.getName()).build();
    }

    public static CountryEntity convertCountryToCountryEntity(Country country) {
        return CountryEntity.builder().name(country.getName()).build();
    }

    public static Country convertCountryEntityToCountry(CountryEntity countryEntity) {
        return Country.builder().name(countryEntity.getName()).build();
    }

    public static CountryResponse convertCountryToCountryResponse(Country country) {
        return CountryResponse.builder().name(country.getName()).build();
    }

    public static List<Country> convertListCountriesEntityToListCountries(List<CountryEntity> listCountriesEntity) {
        List<Country> countries = new ArrayList<>();
        if (!CollectionUtils.isEmpty(listCountriesEntity)) {
            listCountriesEntity.forEach(countryEntity -> countries.add(convertCountryEntityToCountry(countryEntity)));
        }
        return countries;
    }

    public static List<CountryResponse> convertListCountriesToListCountriesResponse(List<Country> countries) {
        List<CountryResponse> listCountriesResponse = new ArrayList<>();
        if (!CollectionUtils.isEmpty(countries)) {
            countries.forEach(country -> listCountriesResponse.add(convertCountryToCountryResponse(country)));
        }
        return listCountriesResponse;
    }

}