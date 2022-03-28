package br.com.server.location.usercases.services.impl;

import br.com.server.location.database.entitys.StateEntity;
import br.com.server.location.database.repositorys.IStateRepository;
import br.com.server.location.domain.entitys.State;
import br.com.server.location.mappers.StateMapper;
import br.com.server.location.usercases.exceptions.NoRecordFoundException;
import br.com.server.location.usercases.exceptions.ValidationFieldException;
import br.com.server.location.usercases.services.ICountryService;
import br.com.server.location.usercases.services.IStateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

public class StateServiceImpl implements IStateService {

    private static final String MSG_ERROR_NENHUM_REGISTRO_ENCONTRADO = "Nenhum registro foi encontrado.";

    private IStateRepository stateRepository;
    private ICountryService countryService;

    public StateServiceImpl(IStateRepository stateRepository, ICountryService countryService) {
        super();
        this.stateRepository = stateRepository;
        this.countryService = countryService;
    }

    @Override
    public List<State> searchAllStates() throws NoRecordFoundException {
        List<StateEntity> statesFound = stateRepository.findAll();
        if (CollectionUtils.isEmpty(statesFound)) {
            throw new NoRecordFoundException(MSG_ERROR_NENHUM_REGISTRO_ENCONTRADO);
        }
        return StateMapper.convertListStatesEntityToListStates(statesFound);
    }

    @Override
    public void deleteState(String stateName) throws ValidationFieldException, NoRecordFoundException {
        validateStateName(stateName);
        stateRepository.delete(StateMapper.convertStateToStateEntity(searchByName(stateName)));
    }

    @Override
    public State updateState(State state) throws ValidationFieldException, NoRecordFoundException {
        validateState(state);
        State stateFound = searchByName(state.getName());
        stateFound.setInitials(state.getInitials());
        stateFound.setCountry(countryService.searchByName(state.getCountry().getName()));
        return StateMapper.convertStateEntityToState(
                stateRepository.save(
                        StateMapper.convertStateToStateEntity(state)
                )
        );
    }

    @Override
    public State registerState(State state) throws ValidationFieldException, NoRecordFoundException {
        validateState(state);
        validateExistsState(state.getName());
        state.setCountry(countryService.searchByName(state.getCountry().getName()));
        return StateMapper.convertStateEntityToState(
                stateRepository.save(
                        StateMapper.convertStateToStateEntity(state)
                )
        );
    }

    @Override
    public State searchByName(String stateName) throws NoRecordFoundException {
        return StateMapper.convertStateEntityToState(stateRepository.findByName(stateName)
                .orElseThrow(() -> new NoRecordFoundException(MSG_ERROR_NENHUM_REGISTRO_ENCONTRADO)));
    }

    protected void validateStateName(String stateName) throws ValidationFieldException {
        if (StringUtils.isBlank(stateName)) {
            throw new ValidationFieldException("O campo nome é obrigatório!");
        }
    }

    protected void validateState(State state) throws ValidationFieldException {
        validateStateName(state.getName());
        if (StringUtils.isBlank(state.getInitials())) {
            throw new ValidationFieldException("O campo Iniciais é obrigatório!");
        }
        if (Objects.isNull(state.getCountry())) {
            throw new ValidationFieldException("O campo País é obrigatório!");
        }
    }

    protected void validateExistsState(String stateName) throws ValidationFieldException {
        if (stateRepository.findByName(stateName).isPresent()) {
            throw new ValidationFieldException("Já existe um Estado registrado com este nome.");
        }
    }

}