package br.com.server.location.usercases.services.impl;

import br.com.server.location.database.entitys.CountryEntity;
import br.com.server.location.database.repositorys.ICountryRepository;
import br.com.server.location.domain.entitys.Country;
import br.com.server.location.usercases.exceptions.NoRecordFoundException;
import br.com.server.location.usercases.exceptions.ValidationFieldException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class CountryServiceImplTest {

    @Mock
    ICountryRepository countryRepository;

    @InjectMocks
    CountryServiceImpl countryService;

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldRegisterCountrySuccessfully() throws ValidationFieldException {
        when(countryRepository.save(any())).thenReturn(CountryEntity.builder().id(1L).name("Brasil").build());
        Assert.assertNotNull(countryService.registerCountry(Country.builder().name("Brasil").build()));
    }

    @Test(expected = ValidationFieldException.class)
    public void shouldThrowErrorOfRegisterCountryIfNameFieldAreMissing() throws ValidationFieldException {
        when(countryRepository.save(any())).thenReturn(CountryEntity.builder().id(1L).name("Brasil").build());
        countryService.registerCountry(Country.builder().name(null).build());
    }

    @Test(expected = ValidationFieldException.class)
    public void shouldThrowErrorOfRegisterCountryIfNameFieldAlreadyExists() throws ValidationFieldException {
        when(countryRepository.findByName(any())).thenReturn(
                Optional.ofNullable(CountryEntity.builder().name("Brasil").build())
        );
        countryService.registerCountry(Country.builder().name("Brasil").build());
    }

    @Test
    public void shouldListAllCountriesSuccessfully() throws NoRecordFoundException {
        when(countryRepository.findAll()).thenReturn(Arrays.asList(CountryEntity.builder().id(1L).name("Brasil").build()));
        Assert.assertEquals(1, countryService.searchAllCountries().size());
    }

    @Test(expected = NoRecordFoundException.class)
    public void shouldThrowErrorOfCountryListEmpty() throws NoRecordFoundException {
        when(countryRepository.findAll()).thenReturn(Arrays.asList());
        countryService.searchAllCountries();
    }

    @Test(expected = NoRecordFoundException.class)
    public void shouldThrowErrorOfCountryListNull() throws NoRecordFoundException {
        when(countryRepository.findAll()).thenReturn(null);
        countryService.searchAllCountries();
    }

    @Test
    public void shouldDeleteCountrySuccessfully() throws ValidationFieldException, NoRecordFoundException {
        when(countryRepository.findByName(any())).thenReturn(
                Optional.ofNullable(CountryEntity.builder().name("Brasil").build())
        );
        countryService.deleteCountry("Brasil");
    }

    @Test(expected = ValidationFieldException.class)
    public void shouldThrowErrorOfDeleteCountryIfNameFieldAreMissing() throws ValidationFieldException, NoRecordFoundException {
        countryService.deleteCountry(null);
    }

    @Test(expected = NoRecordFoundException.class)
    public void shouldThrowErrorOfDeleteCountryIfCountryNameNotFound() throws ValidationFieldException, NoRecordFoundException {
        when(countryRepository.findByName(any())).thenReturn(Optional.empty());
        countryService.deleteCountry("Brasil");
    }

}