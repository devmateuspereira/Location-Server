package br.com.server.location.controllers.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AddressDTO implements Serializable {

    private Integer number;

    private String zipCod;

    private String street;

    private String district;

    private String complement;

    private Long city;

}