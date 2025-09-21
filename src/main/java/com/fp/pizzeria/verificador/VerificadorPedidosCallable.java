package com.fp.pizzeria.verificador;



import com.fp.pizzeria.restaurante.Pedido;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Callable que verifica si los pedidos cumplen ciertas reglas.
 * Retorna cuántos pedidos son válidos.
 */
public class VerificadorPedidosCallable implements Callable<Integer> {
    private final List<Pedido> pedidos;
    private final List<String> ingredientesProhibidos;

    public VerificadorPedidosCallable(List<Pedido> pedidos, List<String> ingredientesProhibidos) {
        this.pedidos = pedidos;
        this.ingredientesProhibidos = ingredientesProhibidos;
    }

    /**
     * Realiza la verificación de los pedidos.
     * Devuelve el número de pedidos válidos.
     * @return Número de pedidos válidos.
     */
    @Override
    public Integer call() {
        int validos = 0;
        for (Pedido p : pedidos) {
            boolean valido = true;
            for (String ing : ingredientesProhibidos) {
                if (p.getDescripcion().toLowerCase().contains(ing.toLowerCase())) {
                    valido = false;
                    break;
                }
            }
            if (valido) {
                validos++;
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Validados " + validos + " pedidos");
        return validos;
    }
}
