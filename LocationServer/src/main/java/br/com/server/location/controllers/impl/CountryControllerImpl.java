package br.com.server.location.controllers.impl;

import br.com.server.location.controllers.ICountryController;
import br.com.server.location.controllers.dtos.CountryDTO;
import br.com.server.location.controllers.responses.CountryResponse;
import br.com.server.location.mappers.CountryMapper;
import br.com.server.location.usercases.exceptions.NoRecordFoundException;
import br.com.server.location.usercases.exceptions.ValidationFieldException;
import br.com.server.location.usercases.services.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/country")
public class CountryControllerImpl implements ICountryController {

    private ICountryService countryService;

    @Autowired
    public CountryControllerImpl(ICountryService countryService) {
        super();
        this.countryService = countryService;
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<CountryResponse> registerCountry(@RequestBody CountryDTO dto) throws ValidationFieldException {
        return ResponseEntity.ok(
                CountryMapper.convertCountryToCountryResponse(
                        countryService.registerCountry(
                                CountryMapper.convertCountryDtoToCountry(dto)
                        )
                )
        );
    }

    @GetMapping("/search")
    @Override
    public ResponseEntity<List<CountryResponse>> searchAllCountries() throws NoRecordFoundException {
        return ResponseEntity.ok(
                CountryMapper.convertListCountriesToListCountriesResponse(
                        countryService.searchAllCountries()
                )
        );
    }

    @DeleteMapping("/delete")
    @Override
    public void deleteCountry(@RequestBody CountryDTO dto) throws NoRecordFoundException, ValidationFieldException {
        countryService.deleteCountry(dto.getName());
    }

}