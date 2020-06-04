package br.com.api.apirest.controller;

import br.com.api.apirest.model.Planeta;
import br.com.api.apirest.service.PlanetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/planetas")
public class PlanetaController {

    private PlanetaService planetaService;

    public PlanetaController(PlanetaService planetaService) {
        this.planetaService = planetaService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Planeta planeta) {
        try {
            Planeta planetaSalvo = this.planetaService.save(planeta);
            return ResponseEntity.ok(planetaSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(name = "nome", required = false) String nome) {
        List<Planeta> planetas;

        if (nome != null) {
            planetas = this.planetaService.getPlanetaByNome(nome);
        } else {
            planetas = (List<Planeta>) this.planetaService.findAll();
        }

        if (planetas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Nenhum planeta não encontrado!"));
        }

        return ResponseEntity.ok(planetas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
        Optional<Planeta> planeta = this.planetaService.info(id);

        if (planeta.isPresent()) {
            return ResponseEntity.ok(planeta.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Planeta não encontrado!"));
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Planeta planeta) {
        try {
            Planeta planetaSalvo = this.planetaService.save(planeta);
            return ResponseEntity.ok(planetaSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            this.planetaService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Planeta deletado com successo!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        }
    }
}
