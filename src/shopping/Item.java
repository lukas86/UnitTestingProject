package shopping;

public class Item {
    private double unitPrice;
    private int quantity;

    public Item(double unitPrice, int quantity) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }


    //TODO: refactored from feature envy in ShoppingBasket.getTotal()
    public double getSubtotal() {
        return unitPrice * (double)quantity;
    }
}
