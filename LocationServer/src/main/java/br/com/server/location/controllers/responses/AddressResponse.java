package br.com.server.location.controllers.responses;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AddressResponse implements Serializable {

    private Integer number;

    private String zipCod;

    private String street;

    private String district;

    private String complement;

    private CityResponse city;

}