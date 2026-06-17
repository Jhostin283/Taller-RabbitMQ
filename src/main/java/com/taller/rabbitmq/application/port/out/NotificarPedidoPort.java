package com.taller.rabbitmq.application.port.out;

import com.taller.rabbitmq.domain.Pedido;

public interface NotificarPedidoPort {
    void notificar(Pedido pedido);
}
