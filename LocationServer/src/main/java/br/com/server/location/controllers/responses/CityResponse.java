package br.com.server.location.controllers.responses;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class CityResponse implements Serializable {

    private String name;

    private StateResponse state;

    private List<AddressResponse> addresses;

}