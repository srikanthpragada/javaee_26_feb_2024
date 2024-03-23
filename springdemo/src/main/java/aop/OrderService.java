package aop;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
	  public void placeOrder() {
		  System.out.println("Placing order!");
		  // code 
		  //throw new IllegalArgumentException("Invalid details");
	  }
	  
	  public String getOrderStatus(int orderId) {
		  System.out.println("Getting order status  for " + orderId);
		  return String.valueOf(orderId);
	  }
	  public void cancelOrder(int orderId) {
		  System.out.println("Cancelling order!" + orderId);
		  // throw new RuntimeException("Error in Canceling Order!");
	  }
}
