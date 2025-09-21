package com.fp.pizzeria.restaurante;


/**
 * Repartidor como consumidor.
 */
public class Repartidor implements Runnable {
    private final String nombre;
    private final BufferPedidos buffer;
    private final long tiempoEntrega;

    public Repartidor(String nombre, BufferPedidos buffer, long tiempoEntrega) {
        throw new UnsupportedOperationException("A implementar por el estudiante");
    }

    /**
     * Implementación de la interfaz Runnable para el repartidor.
     * Entrega pedidos del buffer hasta que se interrumpa el hilo.
     */
    @Override
    public void run() {
        throw new UnsupportedOperationException("A implementar por el estudiante");
    }
}
