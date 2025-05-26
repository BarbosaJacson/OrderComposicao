import pedidos.*;
import javax.swing.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static pedidos.OrderStatus.PROCESSING;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");
int i;
int N;

        System.out.println("Enter cliente data:  ");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Birth date (DD/MM/YYYY):  ");
        Date birthDate;
        try {
            birthDate = sdf.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid Date. Use the format DD/MM/YYYY.");

            return;
        }

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:  ");
        System.out.print("Status: ");
        int status = scanner.nextInt();
        System.out.print("How many items to this order? ");
        N = scanner.nextInt();
        scanner.nextLine();
        List<OrderItem> itensLista = new ArrayList<>();
        Date date = new Date();
        Order order = new Order(client, date, OrderStatus.values()[status], itensLista);

         for (i = 0; i < N; i++) {  System.out.println("Enter #"+(i+1)+" item data: ");
             System.out.print("Product name: ");
             String product = scanner.nextLine();
             System.out.print("Product price: ");
             double price = scanner.nextDouble();
             System.out.print("Quantity: ");
             int quantity = scanner.nextInt();
             scanner.nextLine();

             Product products = new Product(product, price, quantity);
             OrderItem orderItem = new OrderItem(quantity, products);

             order.addItem(orderItem);

        }  scanner.close();

        order.printOrderSummary();

    }
}