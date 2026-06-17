package com.taller.rabbitmq.application.service;

import com.taller.rabbitmq.application.port.in.CrearPedidoUseCase;
import com.taller.rabbitmq.application.port.out.NotificarPedidoPort;
import com.taller.rabbitmq.domain.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CrearPedidoService implements CrearPedidoUseCase {

    private final NotificarPedidoPort notificarPedidoPort;

    public CrearPedidoService(NotificarPedidoPort notificarPedidoPort) {
        this.notificarPedidoPort = notificarPedidoPort;
    }

    @Override
    public void crearPedido(Pedido pedido) {
        log.info("LÓGICA DE NEGOCIO: Registrando el pedido {}", pedido.getId());
        
        // Aquí iría la lógica de persistencia en base de datos, validaciones, etc.

        // Al finalizar, se notifica el pedido a través del puerto de salida (RabbitMQ)
        notificarPedidoPort.notificar(pedido);
    }
}
