package pizzeria.verificador;

import com.fp.pizzeria.restaurante.Pedido;
import com.fp.pizzeria.verificador.VerificadorPedidosCallable;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.*;

public class VerificadorPedidosCallableTest {

    @Test
    public void testVerificacion() throws InterruptedException, ExecutionException {
        List<Pedido> pedidos1 = Arrays.asList(
                new Pedido("Pizza margarita"),
                new Pedido("Pizza con piña")
        );
        List<Pedido> pedidos2 = Arrays.asList(
                new Pedido("Pizza 4 quesos"),
                new Pedido("Pizza pepperoni extra")
        );

        List<String> prohibidos = Arrays.asList("piña", "pepperoni extra");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = executor.submit(new VerificadorPedidosCallable(pedidos1, prohibidos));
        Future<Integer> f2 = executor.submit(new VerificadorPedidosCallable(pedidos2, prohibidos));

        int totalValidos = f1.get() + f2.get();
        executor.shutdown();

        // Solo margarita y 4 quesos son válidas => 2 pedidos válidos
        assertEquals(2, totalValidos);
    }
}
