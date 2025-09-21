package pizzeria.restaurante;

import com.fp.pizzeria.restaurante.BufferPedidos;
import com.fp.pizzeria.restaurante.Pedido;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BufferPedidosTest {

    @Test
    public void testPutTake() throws InterruptedException {
        BufferPedidos buffer = new BufferPedidos(2);
        Pedido p1 = new Pedido("A");
        Pedido p2 = new Pedido("B");

        buffer.put(p1);
        buffer.put(p2);

        assertEquals(2, buffer.size());

        Pedido t1 = buffer.take();
        assertNotNull(t1);
        assertEquals(1, buffer.size());

        Pedido t2 = buffer.take();
        assertNotNull(t2);
        assertEquals(0, buffer.size());
    }
}
