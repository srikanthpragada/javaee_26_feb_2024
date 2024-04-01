package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InterestController {

	@GetMapping("/interest")
	public String showForm() {
		return "interest";
	}

	@PostMapping("/interest")
	public String calculateInterest(int amount, int rate, Model model) {
		int interest = amount * rate / 100; 
		model.addAttribute("amount", amount);
		model.addAttribute("rate", rate);
		model.addAttribute("interest", interest);
		return "interestResult";
	}
}
