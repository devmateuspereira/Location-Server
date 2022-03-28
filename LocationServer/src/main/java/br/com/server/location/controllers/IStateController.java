package br.com.server.location.controllers;

import br.com.server.location.controllers.dtos.StateDTO;
import br.com.server.location.controllers.responses.StateResponse;
import br.com.server.location.usercases.exceptions.NoRecordFoundException;
import br.com.server.location.usercases.exceptions.ValidationFieldException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IStateController {

    @ApiOperation(value = "Registra um estado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de estado"),
            @ApiResponse(code = 406, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<StateResponse> registerState(@RequestBody StateDTO dto) throws ValidationFieldException, NoRecordFoundException;

    @ApiOperation(value = "Lista todos os estados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de response de estados"),
            @ApiResponse(code = 204, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<List<StateResponse>> searchAllStates() throws NoRecordFoundException;

    @ApiOperation(value = "Atualiza um estado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de estado"),
            @ApiResponse(code = 406, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<StateResponse> updateState(@RequestBody StateDTO dto) throws NoRecordFoundException, ValidationFieldException;

    @ApiOperation(value = "Deleta um estado")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Retorna uma mensagem amigável para o usuário"),
            @ApiResponse(code = 406, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public void deleteState(@RequestBody StateDTO dto) throws NoRecordFoundException, ValidationFieldException;

}