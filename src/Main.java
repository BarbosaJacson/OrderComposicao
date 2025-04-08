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
            System.out.println("Data inválida. Use o formato DD/MM/YYYY.");

            return;
        }

        Client client = new Client(name, email, birthDate); // Instanciação (criando objeto) da classe Client para
        // os atributos name,email e birthDate.

        System.out.println("Enter order data:  ");
        System.out.print("Status: ");
        int status = scanner.nextInt();
        System.out.print("How many items to this order? ");
        N = scanner.nextInt();
        scanner.nextLine();
        List<OrderItem> itensLista = new ArrayList<>();
        Date date = new Date(); //"Criando um objeto Date para registrar o momento atual do pedido."
        Order order = new Order(client, date, OrderStatus.values()[status], itensLista);
        //Instanciando a classe Order com o cliente, data atual, status do pedido e lista de itens.

         for (i = 0; i < N; i++) {  System.out.println("Enter #"+(i+1)+" item data: ");
             System.out.print("Product name: ");
             String produto = scanner.nextLine();
             System.out.print("Product price: ");
             double price = scanner.nextDouble();
             System.out.print("Quantity: ");
             int quantidade = scanner.nextInt();
             scanner.nextLine();

             // Instanciando a classe Product com nome, preço e quantidade.
             Product product = new Product(produto, price, quantidade);

             // Instanciando a classe OrderItem com a quantidade e o produto.
             OrderItem orderItem = new OrderItem(quantidade, product);

             // Adicionando o item do pedido à lista de itens da classe Order, dentro de um loop for.
             order.addItem(orderItem);

        }  scanner.close();
// Chamada ao método que imprime tudo
        order.printOrderSummary();

    }
}