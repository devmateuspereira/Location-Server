package br.com.server.location.controllers.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CityDTO implements Serializable {

    private String name;

    private Long state;

}