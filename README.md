# Taller 9: Simulación de Comunicación Asíncrona con RabbitMQ

## Introducción
En la actualidad, las aplicaciones distribuidas requieren mecanismos que permitan intercambiar información de manera eficiente y desacoplada. **RabbitMQ** es un broker de mensajes que facilita la comunicación asíncrona entre diferentes componentes de un sistema mediante colas de mensajes.

En este taller se ha desarrollado una simulación utilizando Spring Boot y RabbitMQ, donde un Productor envía mensajes (pedidos de una tienda) y un Consumidor los procesa, demostrando el funcionamiento de la mensajería orientada a eventos.

## Estructura del Proyecto
- **src/**: Código fuente de la aplicación Spring Boot.
- **docker-compose.yml**: Orquestación para levantar el broker RabbitMQ localmente con su panel de administración.

## Documentación y Uso

Para probar y ejecutar el taller:
1. **Infraestructura:** Ejecuta `docker-compose up -d` en la raíz para levantar RabbitMQ.
2. **Aplicación:** Inicia la aplicación de Spring Boot desde tu IDE o con Maven.
3. **Pruebas:** Envía una petición `POST` a `http://localhost:8080/api/pedidos` con un body JSON válido simulando la compra.
4. **Validación:** Comprueba el panel de administración de RabbitMQ (`http://localhost:15672`) y los logs de la consola para ver la comunicación asíncrona en acción.

## Objetivos del Taller
* Implementar una simulación de comunicación asíncrona utilizando RabbitMQ.
* Comprender y demostrar el desacoplamiento total entre aplicaciones.
* Configurar un broker RabbitMQ utilizando contenedores (Docker).
* Implementar productores y consumidores de mensajes con Spring Boot utilizando **Arquitectura Hexagonal**.

## Arquitectura del Sistema
El sistema simula un flujo de pedidos en una tienda virtual:
1. **El Cliente** realiza una compra enviando un pedido al servidor.
2. **El Productor** recibe la solicitud y publica el mensaje en RabbitMQ de forma inmediata.
3. **RabbitMQ** retiene y salvaguarda el mensaje en su cola (`cola_pedidos`).
4. **El Consumidor** escucha la cola, recibe el mensaje de forma desacoplada y simula el procesamiento pesado (como la actualización del inventario).

## Tecnologías Utilizadas
* **Lenguaje:** Java 17
* **Framework:** Spring Boot (Spring Web, Spring AMQP)
* **Broker de Mensajería:** RabbitMQ
* **Orquestación:** Docker Compose
* **Diseño:** Arquitectura Hexagonal (Ports and Adapters)
