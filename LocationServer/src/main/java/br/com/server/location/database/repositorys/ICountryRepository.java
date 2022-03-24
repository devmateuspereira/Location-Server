package br.com.server.location.database.repositorys;

import br.com.server.location.database.entitys.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICountryRepository extends JpaRepository<CountryEntity, Long> {

    @Query("SELECT country FROM Country country WHERE UPPER(country.name) LIKE %:name%")
    public Optional<CountryEntity> findByName(@Param("name") String name);

}