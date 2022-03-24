package br.com.server.location.database.repositorys;

import br.com.server.location.database.entitys.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {

}