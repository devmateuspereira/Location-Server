package br.com.server.location.controllers.responses;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class CountryResponse implements Serializable {

    private String error;

    private String name;

    private List<StateResponse> states;

}