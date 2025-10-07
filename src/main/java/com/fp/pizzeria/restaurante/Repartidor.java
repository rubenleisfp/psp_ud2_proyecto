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
     * Cada repartidor tendrá un nombre y un tiempo de entrega, ya que no tarda
     * lo mismo en entregar el pedido un repartidor junior que uno senior,
     * que ya conoce la ciudad y sus atajos.
     * Trabajará mientras no interrupamos el hilo,
     * tiempo durante el cual irá obteniendo pedidos del buffer para
     * entregarlos. Simularemos el tiempo de entrega con un sleep.
     **/
    @Override
    public void run() {
        throw new UnsupportedOperationException("A implementar por el estudiante");
    }
}
