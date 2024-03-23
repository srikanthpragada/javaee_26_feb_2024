package aop;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

	   public void process() {
		   System.out.println("Processing Payment");
	   }
}
