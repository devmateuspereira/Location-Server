package br.com.server.location.mappers;

import br.com.server.location.controllers.dtos.StateDTO;
import br.com.server.location.controllers.responses.StateResponse;
import br.com.server.location.database.entitys.StateEntity;
import br.com.server.location.domain.entitys.Country;
import br.com.server.location.domain.entitys.State;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class StateMapper {

    public static State convertStateDtoToState(StateDTO dto) {
        return State.builder()
                    .name(dto.getName())
                    .initials(dto.getInitials())
                    .country(Country.builder().name(dto.getCountryName()).build())
                    .build();
    }

    public static StateEntity convertStateToStateEntity(State state) {
        return StateEntity.builder()
                          .name(state.getName())
                          .initials(state.getInitials())
                          .country(CountryMapper.convertCountryToCountryEntity(state.getCountry()))
                          .build();
    }

    public static State convertStateEntityToState(StateEntity stateEntity) {
        return State.builder()
                    .name(stateEntity.getName())
                    .initials(stateEntity.getInitials())
                    .country(CountryMapper.convertCountryEntityToCountry(stateEntity.getCountry()))
                    .build();
    }

    public static StateResponse convertStateToStateResponse(State state) {
        return StateResponse.builder()
                            .name(state.getName())
                            .initials(state.getInitials())
                            .country(CountryMapper.convertCountryToCountryResponse(state.getCountry()))
                            .build();
    }

    public static List<StateEntity> convertListStatesToListStatesEntity(List<State> states) {
        List<StateEntity> listStatesEntity = new ArrayList<>();
        if (!CollectionUtils.isEmpty(states)) {
            states.forEach(state -> listStatesEntity.add(convertStateToStateEntity(state)));
        }
        return listStatesEntity;
    }

    public static List<State> convertListStatesEntityToListStates(List<StateEntity> listStatesEntity) {
        List<State> states = new ArrayList<>();
        if (!CollectionUtils.isEmpty(listStatesEntity)) {
            listStatesEntity.forEach(stateEntity -> states.add(convertStateEntityToState(stateEntity)));
        }
        return states;
    }

    public static List<StateResponse> convertListStatesToListStatesResponse(List<State> states) {
        List<StateResponse> listStatesResponse = new ArrayList<>();
        if (!CollectionUtils.isEmpty(states)) {
            states.forEach(state -> listStatesResponse.add(convertStateToStateResponse(state)));
        }
        return listStatesResponse;
    }

}