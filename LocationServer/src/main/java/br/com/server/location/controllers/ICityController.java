package br.com.server.location.controllers;

import br.com.server.location.controllers.responses.CityResponse;
import br.com.server.location.domain.entitys.City;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICityController {

    @ApiOperation(value = "Registra uma cidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de cidade"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<CityResponse> registerCity(@RequestBody City city);

    @ApiOperation(value = "Lista todos as cidades")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de response de cidades"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<List<CityResponse>> searchAllCities();

    @ApiOperation(value = "Busca uma cidade por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de cidade"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<CityResponse> searchCityById(@PathVariable("cityId") Long cityId);

    @ApiOperation(value = "Atualiza uma cidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de cidade"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<CityResponse> updateCity(@RequestBody City city);

    @ApiOperation(value = "Deleta uma cidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de cidade"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<CityResponse> deleteCity(@PathVariable("cityId") Long cityId);

}