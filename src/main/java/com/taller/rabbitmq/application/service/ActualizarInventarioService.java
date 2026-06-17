package com.taller.rabbitmq.application.service;

import com.taller.rabbitmq.application.port.in.ActualizarInventarioUseCase;
import com.taller.rabbitmq.domain.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActualizarInventarioService implements ActualizarInventarioUseCase {

    @Override
    public void actualizarInventario(Pedido pedido) {
        log.info("LÓGICA DE NEGOCIO: Procesando la actualización de inventario para el pedido...");
        log.info("Descontando {} unidades del producto: {}", pedido.getCantidad(), pedido.getDescripcion());
    }
}
