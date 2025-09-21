package com.fp.pizzeria.restaurante;


/**
 * PizzeriaApp de la pizzería multihilo - starter
 */
public class PizzeriaApp {
    public static void main(String[] args) throws Exception {
        System.out.println("== PSP UD2 - Pizzería multihilo (starter) ==");

        BufferPedidos buffer = new BufferPedidos(5);
        Horno horno = new Horno();

        Thread cocinero1 = new Thread(new Cocinero("Cocinero-1", buffer, horno, 800), "Cocinero-1-thread");
        Thread cocinero2 = new Thread(new Cocinero("Cocinero-2", buffer, horno, 1200), "Cocinero-2-thread");
        Thread repartidor1 = new Thread(new Repartidor("Repartidor-1", buffer, 1500), "Repartidor-1-thread");

        cocinero1.start();
        cocinero2.start();
        repartidor1.start();

        // Mostrar estados de hilos
        Thread.sleep(500);
        System.out.println("Estado de " + cocinero1.getName() + ": " + cocinero1.getState());
        System.out.println("Estado de " + repartidor1.getName() + ": " + repartidor1.getState());

        // Esperar a hilos
        cocinero1.join();
        cocinero2.join();
        repartidor1.interrupt(); // interrumpimos el repartidor para terminar la demo
        repartidor1.join();

        System.out.println("Done!");
    }
}
