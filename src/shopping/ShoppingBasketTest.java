package shopping;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingBasketTest {

    @Test
    void totalOfEmptyShoppingBasket() {
        ShoppingBasket shoppingBasket = buildShoppingBasketWithItems();
        assertEquals(0.0, shoppingBasket.getTotal(), 0.0);
    }

    @Test
    void totalOfSingleItem() {
        ShoppingBasket shoppingBasket = buildShoppingBasketWithItems(new Item(100.0, 1));
        assertEquals(100.0, shoppingBasket.getTotal(), 0.0);
    }

    @Test
    void totalOfTwoItems() {
        ShoppingBasket shoppingBasket = buildShoppingBasketWithItems(new Item(100.0, 1), new Item(200.0, 1));
        assertEquals(300.0, shoppingBasket.getTotal(), 0.0);
    }

    @Test
    public void totalOfItemWithQuantityTwo() {
        ShoppingBasket shoppingBasket = buildShoppingBasketWithItems(new Item(100.0, 2));
        assertEquals(200.0, shoppingBasket.getTotal());
    }

    private ShoppingBasket buildShoppingBasketWithItems(Item... items) {
        return new ShoppingBasket(Arrays.asList(items));
    }
}
