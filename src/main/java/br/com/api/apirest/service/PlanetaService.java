package br.com.api.apirest.service;

import br.com.api.apirest.model.Planeta;
import br.com.api.apirest.repository.PlanetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetaService {

    private PlanetaRepository planetaRepository;

    public PlanetaService(PlanetaRepository planetaRepository) {
        this.planetaRepository = planetaRepository;
    }

    public Planeta save(Planeta planeta) {
        return this.planetaRepository.save(planeta);
    }

    public Iterable<Planeta> findAll() {
        return this.planetaRepository.findAll();
    }

    public Planeta update(Planeta planeta) {
        return this.planetaRepository.save(planeta);
    }

    public void delete(Long id) {
        this.planetaRepository.deleteById(id);
    }

    public Optional<Planeta> info(Long id) {
        return this.planetaRepository.findById(id);
    }

    public List<Planeta> getPlanetaByNome(String nome) {
        return this.planetaRepository.findPlanetaByName(nome);
    }
}
