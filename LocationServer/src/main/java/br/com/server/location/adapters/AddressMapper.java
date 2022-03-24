package br.com.server.location.adapters;

import br.com.server.location.controllers.dtos.AddressDTO;
import br.com.server.location.controllers.responses.AddressResponse;
import br.com.server.location.controllers.responses.CityResponse;
import br.com.server.location.database.entitys.AddressEntity;
import br.com.server.location.domain.entitys.Address;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressMapper {

    public static Address convertAddressRequestToAddress(AddressDTO addressRequest) {
        return Address.builder()
                .number(addressRequest.getNumber())
                .zipCod(addressRequest.getZipCod())
                .street(addressRequest.getStreet())
                .district(addressRequest.getDistrict())
                .complement(addressRequest.getComplement())
                .build();
    }

    public static Address convertAddressEntityToAddress(AddressEntity addressEntity) {
        return Address.builder()
                .number(addressEntity.getNumber())
                .zipCod(addressEntity.getZipCod())
                .street(addressEntity.getStreet())
                .district(addressEntity.getDistrict())
                .complement(addressEntity.getComplement())
                .build();
    }

    private static AddressEntity convertAddressToAddressEntity(Address address) {
        return AddressEntity.builder()
                .number(address.getNumber())
                .zipCod(address.getZipCod())
                .street(address.getStreet())
                .district(address.getDistrict())
                .complement(address.getComplement())
                .build();
    }

    public static AddressResponse convertAddressToAddressResponse(Address address, CityResponse cityResponse) {
        return AddressResponse.builder()
                .number(address.getNumber())
                .zipCod(address.getZipCod())
                .street(address.getStreet())
                .district(address.getDistrict())
                .complement(address.getComplement())
                .city(cityResponse)
                .build();
    }

    public static List<Address> convertListAddressEntityToListAddress(List<AddressEntity> listAddressEntity) {
        List<Address> addresses = new ArrayList<>();
        if (!CollectionUtils.isEmpty(listAddressEntity)) {
            listAddressEntity.forEach(entity -> addresses.add(convertAddressEntityToAddress(entity)));
        }
        return addresses;
    }

    private static List<AddressEntity> convertListAddressToListAddressEntity(List<Address> addresses) {
        List<AddressEntity> listAddressEntity = new ArrayList<>();
        if (!CollectionUtils.isEmpty(addresses)) {
            addresses.forEach(address -> listAddressEntity.add(convertAddressToAddressEntity(address)));
        }
        return listAddressEntity;
    }

    private static List<AddressEntity> convertListAddressToListAddressResponse(List<Address> addresses) {
        List<AddressEntity> listAddressResponse = new ArrayList<>();
        if (!CollectionUtils.isEmpty(addresses)) {
//            addresses.forEach(address -> listAddressResponse.add(convertAddressToAddressResponse(address)));
        }
        return listAddressResponse;
    }

}