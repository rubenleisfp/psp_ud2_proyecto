package com.fp.pizzeria.restaurante;

/**
 * Recurso compartido: Horno.
 * Método sincronizado para asegurar exclusión mutua.
 */
public class Horno {

    /**
     * Método sincronizado para asegurar exclusión mutua en el horno.
     * El hilo que llama a este método se bloquea hasta que el horno esté libre.
     * Luego, el hilo duerme durante el tiempo especificado por parámetro
     * y posteriormente libera el horno.
     * @param quien nombre del hilo que llama a este método
     * @param tiempoMs tiempo en milisegundos durante el cual se bloquea el hilo
     * @throws InterruptedException si el hilo es interrumpido mientras se encuentra bloqueado
     */
    public synchronized void usarHorno(String quien, long tiempoMs) throws InterruptedException {
        System.out.println(quien + " - Usando el horno...");
        Thread.sleep(tiempoMs);
        System.out.println(quien + " - Liberando el horno");
    }
}
