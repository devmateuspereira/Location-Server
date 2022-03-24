package br.com.server.location.controllers.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class StateDTO implements Serializable {

    private String name;

    private String initials;

    private Long country;

}