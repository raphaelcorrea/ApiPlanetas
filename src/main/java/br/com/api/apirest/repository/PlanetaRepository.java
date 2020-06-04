package br.com.api.apirest.repository;

import br.com.api.apirest.model.Planeta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetaRepository extends CrudRepository<Planeta, Long> {

    @Query("SELECT p FROM Planeta p WHERE UPPER(p.nome) LIKE CONCAT('%',UPPER(:nome),'%') ")
    List<Planeta> findPlanetaByName(String nome);
}
