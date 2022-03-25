package br.com.server.location.controllers;

import br.com.server.location.controllers.dtos.CountryDTO;
import br.com.server.location.controllers.responses.CountryResponse;
import br.com.server.location.usercases.exceptions.NoRecordFoundException;
import br.com.server.location.usercases.exceptions.ValidationFieldException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICountryController {

    @ApiOperation(value = "Registra um país")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de país"),
            @ApiResponse(code = 406, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<CountryResponse> registerCountry(@RequestBody CountryDTO dto) throws ValidationFieldException;

    @ApiOperation(value = "Lista todos os países")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de response de países"),
            @ApiResponse(code = 204, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<List<CountryResponse>> searchAllCountries() throws NoRecordFoundException;

    @ApiOperation(value = "Deleta um país")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de país"),
            @ApiResponse(code = 204, message = "Retorna uma mensagem amigável para o usuário"),
            @ApiResponse(code = 406, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public void deleteCountry(@RequestBody CountryDTO dto) throws NoRecordFoundException, ValidationFieldException;

}