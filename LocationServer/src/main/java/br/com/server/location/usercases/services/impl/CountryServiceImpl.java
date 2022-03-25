package br.com.server.location.usercases.services.impl;

import br.com.server.location.database.entitys.CountryEntity;
import br.com.server.location.database.repositorys.ICountryRepository;
import br.com.server.location.domain.entitys.Country;
import br.com.server.location.mappers.CountryMapper;
import br.com.server.location.usercases.exceptions.NoRecordFoundException;
import br.com.server.location.usercases.exceptions.ValidationFieldException;
import br.com.server.location.usercases.services.ICountryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class CountryServiceImpl implements ICountryService {

    private static final String MSG_ERROR_NENHUM_REGISTRO_ENCONTRADO = "Nenhum registro foi encontrado.";

    private ICountryRepository countryRepository;

    public CountryServiceImpl(ICountryRepository countryRepository) {
        super();
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> searchAllCountries() throws NoRecordFoundException {
        List<CountryEntity> countriesFound = countryRepository.findAll();
        if (CollectionUtils.isEmpty(countriesFound)) {
            throw new NoRecordFoundException(MSG_ERROR_NENHUM_REGISTRO_ENCONTRADO);
        }
        return CountryMapper.convertListCountriesEntityToListCountries(countriesFound);
    }

    @Override
    public void deleteCountry(Country country) throws ValidationFieldException, NoRecordFoundException {
        validateCountryName(country.getName());
        countryRepository.delete(countryRepository.findByName(country.getName())
                .orElseThrow(() -> new NoRecordFoundException(MSG_ERROR_NENHUM_REGISTRO_ENCONTRADO))
        );
    }

    @Override
    public Country registerCountry(Country country) throws ValidationFieldException {
        validateCountryName(country.getName());
        validateExistsCountry(country.getName());
        return CountryMapper.convertCountryEntityToCountry(
                countryRepository.save(
                        CountryMapper.convertCountryToCountryEntity(country)
                )
        );
    }

    protected void validateCountryName(String countryName) throws ValidationFieldException {
        if (StringUtils.isBlank(countryName)) {
            throw new ValidationFieldException("O campo nome é obrigatório!");
        }
    }

    protected void validateExistsCountry(String countryName) throws ValidationFieldException {
        if (countryRepository.findByName(countryName).isPresent()) {
            throw new ValidationFieldException("Já existe um País registrado com este nome.");
        }
    }

}