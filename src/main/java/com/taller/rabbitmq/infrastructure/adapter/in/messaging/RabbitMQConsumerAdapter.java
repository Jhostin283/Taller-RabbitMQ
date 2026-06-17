package com.taller.rabbitmq.infrastructure.adapter.in.messaging;

import com.taller.rabbitmq.application.port.in.ActualizarInventarioUseCase;
import com.taller.rabbitmq.domain.Pedido;
import com.taller.rabbitmq.infrastructure.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQConsumerAdapter {

    private final ActualizarInventarioUseCase actualizarInventarioUseCase;

    public RabbitMQConsumerAdapter(ActualizarInventarioUseCase actualizarInventarioUseCase) {
        this.actualizarInventarioUseCase = actualizarInventarioUseCase;
    }

    @RabbitListener(queues = RabbitMQConfig.NOMBRE_COLA)
    public void recibirMensaje(Pedido pedido) {
        log.info("==================================================");
        log.info("ADAPTADOR DE ENTRADA (MESSAGING): Mensaje recibido de RabbitMQ");
        
        // Delega la responsabilidad de negocio al Caso de Uso correspondiente
        actualizarInventarioUseCase.actualizarInventario(pedido);
        
        log.info("==================================================");
    }
}
