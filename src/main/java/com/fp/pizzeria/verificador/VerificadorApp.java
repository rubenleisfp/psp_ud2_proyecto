package com.fp.pizzeria.verificador;

import com.fp.pizzeria.restaurante.Pedido;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VerificadorApp {
    public static void main(String[] args) {
        // Ejemplo con ExecutorService + Callable (verificación de pedidos)
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Pedido> lote1 = List.of(new Pedido("Pizza margarita"), new Pedido("Pizza con piña"));
        List<Pedido> lote2 = List.of(new Pedido("Pizza 4 quesos"), new Pedido("Pizza pepperoni extra"));
        List<String> prohibidos = List.of("piña", "pepperoni extra");

        Future<Integer> r1 = executor.submit(new VerificadorPedidosCallable(lote1, prohibidos));
        Future<Integer> r2 = executor.submit(new VerificadorPedidosCallable(lote2, prohibidos));

        int totalValidos = 0;
        try {
            totalValidos = r1.get() + r2.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Pedidos válidos: " + totalValidos);

        executor.shutdown();


    }
}
