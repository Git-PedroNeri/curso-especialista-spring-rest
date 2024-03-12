package com.algaworks.algafood.di.service.event;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.service.ClienteAtivadoEvent;
import org.springframework.stereotype.Component;


public class MyEventClass {

   private Cliente cliente;

    public MyEventClass(Cliente cliente) {
        super();
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }







}
