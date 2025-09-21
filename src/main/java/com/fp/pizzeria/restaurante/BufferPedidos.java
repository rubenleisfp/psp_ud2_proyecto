package com.fp.pizzeria.restaurante;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Buffer de pedidos con wait/notify (capacidad limitada).
 * Implementación clásica para practicar synchronized, wait y notifyAll.
 */
public class BufferPedidos {
    private final Queue<Pedido> cola = new LinkedList<>();
    private final int capacidad;

    public BufferPedidos(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Añadir un pedido al buffer (si no hay espacio, espera).
     * @param p el pedido a añadir
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public synchronized void put(Pedido p) throws InterruptedException {
        while (cola.size() >= capacidad) {
            System.out.println(Thread.currentThread().getName() + " - Buffer lleno, esperando...");
            wait();
        }
        cola.add(p);
        System.out.println(Thread.currentThread().getName() + " - Añadido " + p + " (size=" + cola.size() + ")");
        notifyAll();
    }

    /**
     * Tomar un pedido del buffer (si no hay, espera).
     * @return el pedido tomado
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public synchronized Pedido take() throws InterruptedException {
        while (cola.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " - Buffer vacío, esperando...");
            wait();
        }
        Pedido p = cola.poll();
        System.out.println(Thread.currentThread().getName() + " - Tomado " + p + " (size=" + cola.size() + ")");
        notifyAll();
        return p;
    }

    public synchronized int size() {
        return cola.size();
    }
}
