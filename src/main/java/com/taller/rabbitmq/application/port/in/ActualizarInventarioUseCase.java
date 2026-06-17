package com.taller.rabbitmq.application.port.in;

import com.taller.rabbitmq.domain.Pedido;

public interface ActualizarInventarioUseCase {
    void actualizarInventario(Pedido pedido);
}
