package com.fp.pizzeria.restaurante;

/**
 * Pedido simple para la pizzería.
 */
public class Pedido {
    private static int COUNTER = 0;
    private final int id;
    private final String descripcion;

    public Pedido(String descripcion) {
        throw new UnsupportedOperationException("A implementar por el estudiante");
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Pedido{" + id + ": '" + descripcion + "'}";
    }
}
