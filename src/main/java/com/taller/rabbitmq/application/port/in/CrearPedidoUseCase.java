package com.taller.rabbitmq.application.port.in;

import com.taller.rabbitmq.domain.Pedido;

public interface CrearPedidoUseCase {
    void crearPedido(Pedido pedido);
}
