package CDWarehouseApp;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyCDTest {

    @Test
    void cdIsInStock() throws InsufficientStockException {
        CompactDisc cd = new CompactDisc(10);
        cd.buy(1);
        assertEquals(9, cd.getStockCount());
    }

    @Test
    void insufficientStock() {
        assertThrows(InsufficientStockException.class, () -> new CompactDisc(0).buy(1));
    }

}
