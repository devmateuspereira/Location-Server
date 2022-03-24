package br.com.server.location.usercases.services;

import br.com.server.location.domain.entitys.City;

import java.util.List;

public interface ICityService {

    public List<City> searchAllCities() throws CityException;

    public void deleteCity(Long cityId) throws CityException;

    public City updateCity(City city) throws CityException;

    public City searchCityById(Long cityId) throws CityException;

    public City registerCity(City city) throws CityException;

}