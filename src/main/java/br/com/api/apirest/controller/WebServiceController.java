package br.com.api.apirest.controller;

import br.com.api.apirest.service.WebService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/planetas/consulta")
public class WebServiceController {

    private WebService webService;

    public WebServiceController(WebService webService) {
        this.webService = webService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaPlaneta(@PathVariable("id") Long id) {
        return webService.planetas(id);
    }
}
