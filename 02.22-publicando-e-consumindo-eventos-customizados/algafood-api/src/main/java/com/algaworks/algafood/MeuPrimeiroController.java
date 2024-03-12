package com.algaworks.algafood;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.service.AtivacaoClienteService;
import com.algaworks.algafood.di.service.EventPublisherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuPrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    private final EventPublisherService eventPublisherService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService, EventPublisherService eventPublisherService) {
        this.ativacaoClienteService = ativacaoClienteService;
        this.eventPublisherService = eventPublisherService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente joao = new Cliente("João", "joao@xyz.com", "3499998888");

        ativacaoClienteService.ativar(joao);

        return "Hello!";
    }

    @GetMapping("/event")
    public void chamandoEvetListener() {
        eventPublisherService.runCarroLigado();
//        eventPublisherService.runEventPublisher();

    }

}
