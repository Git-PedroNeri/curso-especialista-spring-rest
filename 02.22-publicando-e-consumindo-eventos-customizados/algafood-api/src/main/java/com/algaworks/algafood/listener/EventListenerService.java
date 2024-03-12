package com.algaworks.algafood.listener;


import com.algaworks.algafood.di.modelo.CarroLigado;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;
import com.algaworks.algafood.di.service.event.MyEventClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;


    @EventListener
    public void ficaEscutandoUmSinalDaClasseCarroLigadoEQuandoEscutaRealizaAlgo(CarroLigado carro){
        System.out.println("Carroligado");
    }

    @EventListener
    public void listeningTenSeconds(MyEventClass event) {
        System.out.println("Iniciei 10 secs");
        awaitTenSeconds(10);
        System.out.println("Terminei 10 secs");
//        notificador.notificar(event.getCliente(), "Seu evento foi ouvido");
    }

    @EventListener
    public void listeningFiveSeconds(MyEventClass event) {
        System.out.println("Iniciei 5 secs");
        awaitTenSeconds(5);
        System.out.println("Terminei 5 secs");
//        notificador.notificar(event.getCliente(), "Seu evento foi ouvido");
    }


    public void awaitTenSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000); // 10 segundos = 10000 milissegundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura o status de interrupção
            // Lidar com a exceção, se necessário
        }
    }


}
