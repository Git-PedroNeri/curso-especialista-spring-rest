package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas") //, produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cozinha>> listar1() {
        System.out.println("LISTAR 1");
        List<Cozinha> cozinhas = cozinhaRepository.listar();

        return cozinhas.isEmpty()? ResponseEntity.status(HttpStatus.NO_CONTENT).build():ResponseEntity.ok(cozinhas);
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public List<Cozinha> listar2() {
        System.out.println("LISTAR 2");
        return cozinhaRepository.listar();
    }

    @GetMapping("/{code}")
    ResponseEntity<Cozinha> buscarCozinha(@PathVariable Long code) {
        Cozinha cozinha = cozinhaRepository.buscar(code);

        if (cozinha != null) {
            return ResponseEntity.ok(cozinha);
        }

//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/gif", produces = MediaType.IMAGE_GIF_VALUE)
    public ResponseEntity<Resource> getGif() {
        // Carrega a imagem GIF do classpath
        Resource gifFile = new ClassPathResource("giphy.gif");

        // Retorna a imagem GIF
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_GIF)
                .body(gifFile);
    }

}
