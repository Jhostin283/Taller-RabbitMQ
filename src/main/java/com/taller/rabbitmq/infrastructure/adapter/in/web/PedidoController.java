package com.taller.rabbitmq.infrastructure.adapter.in.web;

import com.taller.rabbitmq.application.port.in.CrearPedidoUseCase;
import com.taller.rabbitmq.domain.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final CrearPedidoUseCase crearPedidoUseCase;

    public PedidoController(CrearPedidoUseCase crearPedidoUseCase) {
        this.crearPedidoUseCase = crearPedidoUseCase;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> crearPedido(@RequestBody Pedido request) {
        // Asignar un ID si no viene en el request
        if (request.getId() == null || request.getId().isEmpty()) {
            request.setId(UUID.randomUUID().toString());
        }
        
        // El adaptador delega la ejecución al caso de uso de la capa de aplicación
        crearPedidoUseCase.crearPedido(request);
        
        // Respuesta profesional estructurada en JSON
        Map<String, Object> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("trackingId", request.getId());
        response.put("mensaje", "Su pedido ha sido recibido y está siendo procesado en segundo plano por RabbitMQ.");
        response.put("pedidoEnviado", request);
        
        // 202 ACCEPTED es el código HTTP ideal para peticiones asíncronas
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
