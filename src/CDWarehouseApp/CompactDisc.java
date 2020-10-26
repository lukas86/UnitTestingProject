package CDWarehouseApp;

public class CompactDisc {

    private int stock;
    public CompactDisc(int initialStock) {
        stock = initialStock;
    }

    public int getStockCount() {
        return stock;
    }

    public void buy(int quantity) throws InsufficientStockException {
        if(stock  < quantity) {
            throw new InsufficientStockException();
        }
        stock -= quantity;
    }
}
