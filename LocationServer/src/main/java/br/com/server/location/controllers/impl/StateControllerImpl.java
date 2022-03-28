package br.com.server.location.controllers.impl;

import br.com.server.location.controllers.IStateController;
import br.com.server.location.controllers.dtos.StateDTO;
import br.com.server.location.controllers.responses.StateResponse;
import br.com.server.location.mappers.StateMapper;
import br.com.server.location.usercases.exceptions.NoRecordFoundException;
import br.com.server.location.usercases.exceptions.ValidationFieldException;
import br.com.server.location.usercases.services.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/state")
public class StateControllerImpl implements IStateController {

    private IStateService stateService;

    @Autowired
    public StateControllerImpl(IStateService stateService) {
        this.stateService = stateService;
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<StateResponse> registerState(@RequestBody StateDTO dto) throws ValidationFieldException, NoRecordFoundException {
        return ResponseEntity.ok(
                StateMapper.convertStateToStateResponse(
                        stateService.registerState(
                                StateMapper.convertStateDtoToState(dto)
                        )
                )
        );
    }

    @GetMapping("/search")
    @Override
    public ResponseEntity<List<StateResponse>> searchAllStates() throws NoRecordFoundException {
        return ResponseEntity.ok(
                StateMapper.convertListStatesToListStatesResponse(
                        stateService.searchAllStates()
                )
        );
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<StateResponse> updateState(StateDTO dto) throws NoRecordFoundException, ValidationFieldException {
        return ResponseEntity.ok(
                StateMapper.convertStateToStateResponse(
                        stateService.updateState(
                                StateMapper.convertStateDtoToState(dto)
                        )
                )
        );
    }

    @DeleteMapping("/delete")
    @Override
    public void deleteState(StateDTO dto) throws NoRecordFoundException, ValidationFieldException {
        stateService.deleteState(dto.getName());
    }

}