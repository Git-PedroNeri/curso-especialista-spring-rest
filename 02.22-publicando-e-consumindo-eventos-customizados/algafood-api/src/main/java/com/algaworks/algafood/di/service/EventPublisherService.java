package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.CarroLigado;
import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.service.event.MyEventClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisherService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void runEventPublisher() {
        eventPublisher.publishEvent(new MyEventClass(new Cliente("Clientao", "cliente@email.com ", "1234567890")));
    }

    public void runCarroLigado(){
        eventPublisher.publishEvent(new CarroLigado(true));
    }


}
