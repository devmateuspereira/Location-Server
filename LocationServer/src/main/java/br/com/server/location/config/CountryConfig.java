package br.com.server.location.config;

import br.com.server.location.database.repositorys.ICountryRepository;
import br.com.server.location.usercases.services.ICountryService;
import br.com.server.location.usercases.services.impl.CountryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryConfig {

    @Bean
    public ICountryService loadCountryService(ICountryRepository countryRepository) {
        return new CountryServiceImpl(countryRepository);
    }

}