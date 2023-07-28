package entities;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.enums.OrderStatus;
public class Order {
	private static SimpleDateFormat dates = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
	private Client client;
	private OrderStatus status;
	

	private Date moment;
	private Product product;
	private List <OrderItem> order = new ArrayList<>();
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
  
	public List<OrderItem> getOrder() {
		return order;
	}
	
	public void addItem(OrderItem orders) {
		order.add(orders);
	}
	public void removeItem(OrderItem orders) {
		order.add(orders);
	}
	double sum = 0;
	public Double total() {	
		for(OrderItem o: order) {	
			sum+= o.subTotal();		
		}
		return sum;
	}
	@Override
	public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Order moment: " + dates.format(moment) + "\n");
	sb.append("Order status: " + status + "\n");
	sb.append("Client: " + client);
	sb.append("\nOrder items:\n");
	for (OrderItem o: order) {
		sb.append(o + "\n");
		
	}
	sb.append("\nTotal price: ");
	sb.append(String.format("%.2f", total()));
	
	return sb.toString();
	}
}
