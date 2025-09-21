package com.fp.pizzeria.restaurante;


/**
 * Repartidor como consumidor.
 */
public class Repartidor implements Runnable {
    private final String nombre;
    private final BufferPedidos buffer;
    private final long tiempoEntrega;

    public Repartidor(String nombre, BufferPedidos buffer, long tiempoEntrega) {
        this.nombre = nombre;
        this.buffer = buffer;
        this.tiempoEntrega = tiempoEntrega;
    }

    /**
     * Implementación de la interfaz Runnable para el repartidor.
     * Entrega pedidos del buffer hasta que se interrumpa el hilo.
     */
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Pedido p = buffer.take();
                System.out.println(nombre + " - Entregando " + p);
                Thread.sleep(tiempoEntrega);
                System.out.println(nombre + " - Entrega completada " + p);
            }
        } catch (InterruptedException e) {
            System.out.println(nombre + " - Interrumpido y finalizando.");
            Thread.currentThread().interrupt();
        }
    }
}
