package br.com.api.apirest.service;

import br.com.api.apirest.model.PlanetaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class WebService {
    private String url = "https://swapi.dev/api/";
    private Logger log;

    {
        log = LoggerFactory.getLogger(WebService.class);
    }

    public ResponseEntity<?> planetas(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String path = url + "planets/" + id.toString() + "/";
        ResponseEntity<String> response = restTemplate.getForEntity(URI.create(path), String.class);

        info(response.getBody());

        try {
            JsonNode root = extraiJson(response);
            String name = root.path("name").asText();
            String climate = root.path("climate").asText();
            String terrain = root.path("terrain").asText();
            Iterator<JsonNode> iterator = root.path("films").iterator();
            List<String> films = new ArrayList<>();

            while (iterator.hasNext()) {
                films.add(iterator.next().asText());
            }

            PlanetaDTO dto = new PlanetaDTO(name, terrain, climate, films.size());
            return ResponseEntity.ok(dto);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }

    }

    private JsonNode extraiJson(ResponseEntity<String> response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(Objects.requireNonNull(response.getBody()));
    }

    private void info(String text) {
        log.info(text);
    }
}
