package br.com.server.location.controllers.responses;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class StateResponse implements Serializable {

    private String name;

    private String initials;

    private CountryResponse country;

    private List<CityResponse> cities;

}