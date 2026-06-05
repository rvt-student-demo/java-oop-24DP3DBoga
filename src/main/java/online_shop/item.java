package OnlineShop;


public class Item {
    private String product;
    private int qty;
    private int price;
    
    
    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.qty = qty;
        this.price = unitPrice;
    }
    
    public int price() {
        return this.price * this.qty;
    }
    
    public void increaseQuantity() {
        this.qty++;
    }
    
    public String toString() {
        return this.product + ": " + this.qty;
    }
}