package br.com.server.location.controllers;

import br.com.server.location.controllers.responses.StateResponse;
import br.com.server.location.domain.entitys.State;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IStateController {

    @ApiOperation(value = "Registra um estado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de estado"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<StateResponse> registerState(@RequestBody State state);

    @ApiOperation(value = "Lista todos os estados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de response de estados"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<List<StateResponse>> searchAllStates();

    @ApiOperation(value = "Busca um estado por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de estado"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<StateResponse> searchStateById(@PathVariable("stateId") Long stateId);

    @ApiOperation(value = "Atualiza um estado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de estado"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<StateResponse> updateState(@RequestBody State state);

    @ApiOperation(value = "Deleta um estado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de estado"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<StateResponse> deleteState(@PathVariable("stateId") Long stateId);

}