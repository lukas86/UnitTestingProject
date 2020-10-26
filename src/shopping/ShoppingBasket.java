package shopping;

import java.util.List;

public class ShoppingBasket {

    List<Item> itemList;

    public ShoppingBasket(List<Item> itemList) {
        this.itemList = itemList;
    }

    public double getTotal() {
        return itemList.stream().mapToDouble(Item::getSubtotal).sum();
    }


}
