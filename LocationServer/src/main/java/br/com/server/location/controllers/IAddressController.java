package br.com.server.location.controllers;

import br.com.server.location.controllers.dtos.AddressDTO;
import br.com.server.location.controllers.responses.AddressResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IAddressController {

    @ApiOperation(value = "Registra um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de endereço"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<AddressResponse> registerAddress(@RequestBody AddressDTO addressRequest);

    @ApiOperation(value = "Lista todos os endereços")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de response de endereços"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<List<AddressResponse>> searchAllAddress();

    @ApiOperation(value = "Busca um endereço por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de endereço"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<AddressResponse> searchAddressById(@PathVariable("addressId") Long addressId);

    @ApiOperation(value = "Atualiza um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de endereço"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<AddressResponse> updateAddress(@RequestBody AddressDTO addressRequest);

    @ApiOperation(value = "Deleta um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um response de endereço"),
            @ApiResponse(code = 500, message = "Retorna uma mensagem amigável para o usuário"),
    })
    public ResponseEntity<AddressResponse> deleteAddress(@PathVariable("addressId") Long addressId);

}