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
        this.nombre = nombre;
        this.buffer = buffer;
        this.horno = horno;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    /**
     * Implementación de Runnable para un cocinero.
     *
     * Este Runnable representa un cocinero que prepara pizzas y las pone en un buffer
     * compartido. El cocinero utiliza un horno compartido para cocinar las pizzas.
     *
     * Horneará 5 pizzas, el tiempo de horno de cada pizza es de 2000 ms.
     * Una vez horneada la pizza crearán un pedido y lo guardarán en el BufferPedidos
     *
     * @throws InterruptedException si el hilo es interrumpido mientras que está esperando
     */
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                // Simular preparación
                System.out.println(nombre + " - Preparando pizza " + (i + 1));
                Thread.sleep(tiempoPreparacion);
                // Usar horno (recurso compartido)
                horno.usarHorno(nombre, 2000);
                Pedido p = new Pedido("Pizza de " + nombre + " #" + (i + 1));
                buffer.put(p);
            }
            System.out.println(nombre + " - He terminado mis pedidos.");
        } catch (InterruptedException e) {
            System.out.println(nombre + " - Interrumpido.");
            Thread.currentThread().interrupt();
        }
    }
}
