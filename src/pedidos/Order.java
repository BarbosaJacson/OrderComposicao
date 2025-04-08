package pedidos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Client client;
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();


    public Order(Client client, Date moment, OrderStatus status, List<OrderItem> items) {
        this.client = client;
        this.moment = moment;
        this.status = status;
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }



    public String getFormattedMoment() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(moment);

    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double total() {
        double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }
public void printOrderSummary(){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = sdf.format(client.getBirthDate());

        System.out.println("ORDER SUMMARY: ");
        System.out.print("Order moment:  ");
        System.out.println(getFormattedMoment());
        System.out.print("Order status:  ");
        System.out.println(getStatus());
        System.out.print("Client:  ");
        System.out.println(client.getName()+" (" +formattedDate+") "+ " - " + client.getEmail());
        System.out.println("Order items:  ");
    double total=0;
        for (OrderItem item : getItems()) {
      String name = item.getProduct().getName();
      double price = item.getProduct().getPrice();
      int quantidade = item.getQuantity();
      double subtotal = item.subTotal();
      total+=item.subTotal();
      System.out.println(name+", " + "$"+String.format("%.2f", price)+", " +"Quantity: "+ quantidade+", "
              +"Subtotal:  "+"$"+String.format("%.2f", subtotal));


    } System.out.printf("Total price: $%.2f%n", total);
    }
}



