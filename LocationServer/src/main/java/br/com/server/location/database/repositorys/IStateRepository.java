package br.com.server.location.database.repositorys;

import br.com.server.location.database.entitys.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStateRepository extends JpaRepository<StateEntity, Long> {

}