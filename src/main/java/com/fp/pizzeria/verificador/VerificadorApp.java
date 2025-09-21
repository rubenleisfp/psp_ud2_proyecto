package com.fp.pizzeria.verificador;

import com.fp.pizzeria.restaurante.Pedido;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VerificadorApp {
    public static void main(String[] args) {
        List<Pedido> lote1 = List.of(new Pedido("Pizza margarita"), new Pedido("Pizza con piña"));
        List<Pedido> lote2 = List.of(new Pedido("Pizza 4 quesos"), new Pedido("Pizza pepperoni extra"));
        List<String> prohibidos = List.of("piña", "pepperoni extra");

        throw new UnsupportedOperationException("A implementar por el estudiante");


    }
}
