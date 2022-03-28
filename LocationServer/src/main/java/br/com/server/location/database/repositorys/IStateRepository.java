package br.com.server.location.database.repositorys;

import br.com.server.location.database.entitys.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStateRepository extends JpaRepository<StateEntity, Long> {

    @Query("SELECT state FROM StateEntity state WHERE UPPER(state.name) LIKE %:name% ")
    public Optional<StateEntity> findByName(@Param("name") String name);

}