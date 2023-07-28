package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dMYHM = new SimpleDateFormat ("dd/MM/YYYY");
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		
		String clientName = sc.nextLine();
		
		System.out.print("Email: ");
		String clientEmail = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirth = dMYHM.parse(sc.next());
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		
		Client client = new Client(clientName, clientEmail, clientBirth);
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println();
			System.out.println("Enter #" +i+ " item data: ");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem (productQuantity, productPrice, product);
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		
		sc.close();

	}

}
