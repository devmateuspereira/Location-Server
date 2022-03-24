package br.com.server.location.usercases.services.impl;

import br.com.server.location.adapters.CountryMapper;
import br.com.server.location.database.entitys.CountryEntity;
import br.com.server.location.database.repositorys.ICountryRepository;
import br.com.server.location.domain.entitys.Country;
import br.com.server.location.usercases.exceptions.NoRecordFoundException;
import br.com.server.location.usercases.exceptions.ValidationFieldException;
import br.com.server.location.usercases.services.ICountryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

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
    public void deleteCountry(Long countryId) throws ValidationFieldException, NoRecordFoundException {
        countryRepository.delete(CountryMapper.convertCountryToCountryEntity(searchCountryById(countryId)));
    }

    @Override
    public Country searchCountryById(Long countryId) throws ValidationFieldException, NoRecordFoundException {
        validateCountryId(countryId);
        CountryEntity countryFound = countryRepository.findById(countryId).orElse(null);
        validateCountryEntityIsNull(countryFound);
        return CountryMapper.convertCountryEntityToCountry(countryFound);
    }

    @Override
    public Country updateCountry(Long countryId, Country country) throws ValidationFieldException, NoRecordFoundException {
        validateCountryName(country.getName());
        Country countryFound = searchCountryById(countryId);
        countryFound.setName(country.getName());
        return CountryMapper.convertCountryEntityToCountry(
                countryRepository.save(
                        CountryMapper.convertCountryToCountryEntity(countryFound)
                )
        );
    }

    @Override
    public Country registerCountry(Country country) throws ValidationFieldException {
        validateCountryName(country.getName());
        return CountryMapper.convertCountryEntityToCountry(
                countryRepository.save(
                        CountryMapper.convertCountryToCountryEntity(country)
                )
        );
    }

    protected void validateCountryName(String name) throws ValidationFieldException {
        if (StringUtils.isBlank(name)) {
            throw new ValidationFieldException("O campo nome é obrigatório!");
        }
        if (countryRepository.findByName(name).isPresent()) {
            throw new ValidationFieldException("Já existe um País registrado com este nome.");
        }
    }

    protected void validateCountryId(Long id) throws ValidationFieldException {
        if (id == null) {
            throw new ValidationFieldException("O campo id é obrigatório!");
        }
    }

    protected void validateCountryEntityIsNull(CountryEntity countryEntity) throws NoRecordFoundException {
        if (Objects.isNull(countryEntity)) {
            throw new NoRecordFoundException(MSG_ERROR_NENHUM_REGISTRO_ENCONTRADO);
        }
    }

}