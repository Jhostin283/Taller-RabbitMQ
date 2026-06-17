package com.taller.rabbitmq.infrastructure.adapter.out.messaging;

import com.taller.rabbitmq.application.port.out.NotificarPedidoPort;
import com.taller.rabbitmq.domain.Pedido;
import com.taller.rabbitmq.infrastructure.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQProducerAdapter implements NotificarPedidoPort {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducerAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void notificar(Pedido pedido) {
        log.info("ADAPTADOR DE SALIDA (MESSAGING): Enviando el pedido a la infraestructura de RabbitMQ");
        rabbitTemplate.convertAndSend(RabbitMQConfig.NOMBRE_COLA, pedido);
        log.info("Mensaje enviado exitosamente a la cola: {}", RabbitMQConfig.NOMBRE_COLA);
    }
}
