package br.com.server.location.usercases.services;

import br.com.server.location.domain.entitys.State;
import br.com.server.location.usercases.exceptions.NoRecordFoundException;
import br.com.server.location.usercases.exceptions.ValidationFieldException;

import java.util.List;

public interface IStateService {

    public List<State> searchAllStates() throws NoRecordFoundException;

    public void deleteState(String stateName) throws ValidationFieldException, NoRecordFoundException;

    public State updateState(State state) throws ValidationFieldException, NoRecordFoundException;

    public State registerState(State state) throws ValidationFieldException, NoRecordFoundException;

    public State searchByName(String stateName) throws NoRecordFoundException;

}