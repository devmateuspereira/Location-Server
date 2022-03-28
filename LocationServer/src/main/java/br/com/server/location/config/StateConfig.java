package br.com.server.location.config;

import br.com.server.location.database.repositorys.IStateRepository;
import br.com.server.location.usercases.services.ICountryService;
import br.com.server.location.usercases.services.IStateService;
import br.com.server.location.usercases.services.impl.StateServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StateConfig {

    @Bean
    public IStateService loadStateService(IStateRepository stateRepository, ICountryService countryService) {
        return new StateServiceImpl(stateRepository, countryService);
    }

}