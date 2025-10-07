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
     * Cada repartidor tendrá un nombre y un tiempo de entrega, ya que no tarda
     * lo mismo en entregar el pedido un repartidor junior que uno senior,
     * que ya conoce la ciudad y sus atajos.
     * Trabajará mientras no interrupamos el hilo,
     * tiempo durante el cual irá obteniendo pedidos del buffer para
     * entregarlos. Simularemos el tiempo de entrega con un sleep.
     **/
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
