package br.com.server.location.database.repositorys;

import br.com.server.location.database.entitys.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<CityEntity, Long> {

}