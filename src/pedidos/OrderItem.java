package pedidos;

public class OrderItem {
    private int quantity;
    private Product product;

    public OrderItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
    public OrderItem(){

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double subTotal () {
        double sub;

        sub = quantity * product.getPrice();
        return sub;
    }


    @Override
    public String toString() {
        return "OrderItem{" +
                "quantity=" + quantity + product +
                '}';
    }
}
