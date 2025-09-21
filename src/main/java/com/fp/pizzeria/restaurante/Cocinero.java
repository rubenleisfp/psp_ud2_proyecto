package com.fp.pizzeria.restaurante;


/**
 * Cocinero como Runnable (productor).
 */
public class Cocinero implements Runnable {
    private final String nombre;
    private final BufferPedidos buffer;
    private final Horno horno;
    private final long tiempoPreparacion;

    public Cocinero(String nombre, BufferPedidos buffer, Horno horno, long tiempoPreparacion) {
        throw new UnsupportedOperationException("A implementar por el estudiante");
    }

    /**
     * Implementación de Runnable para un cocinero.
     *
     * Este Runnable representa un cocinero que prepara pizzas y las pone en un buffer
     * compartido. El cocinero utiliza un horno compartido para cocinar las pizzas.
     *
     * @throws InterruptedException si el hilo es interrumpido mientras que está esperando
     */
    @Override
    public void run() {
        throw new UnsupportedOperationException("A implementar por el estudiante");
    }
}
