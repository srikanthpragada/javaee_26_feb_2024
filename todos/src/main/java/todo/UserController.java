package todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private TodoRepo todoRepo;

	
	@GetMapping(value = "login")
	public String login(ModelMap model, @RequestParam( value="error", required = false) String error) {
		if(error != null) {
			model.addAttribute("message", "Sorry! Invalid login credentials");
		}
		TodoUser u = new TodoUser();
		model.addAttribute("user", u);
		return "login";
	}
 
	@GetMapping(value = "/register")
	public String register(ModelMap model) {
		TodoUser u = new TodoUser();
		model.addAttribute("user", u);
		return "register";
	}

	@PostMapping(value = "/register")
	public String register(ModelMap model, TodoUser u) {
		// Insert user details into table
		try {
			userRepo.save(u);
			return "redirect:login";
		} catch (Exception ex) {
			System.out.println(ex);
			model.addAttribute("user", u);
			model.addAttribute("message", "Sorry! Registration Failed. Please try again!");
			return "register";
		}
	}

	@GetMapping(value = "home")
	public String home(ModelMap model, HttpSession session, HttpServletRequest request) {
		String username = request.getUserPrincipal().getName();
		//String username = (String) session.getAttribute("username");
		List<Todo> todos = todoRepo.getRecentTodosByUser(username);
		// Take only first 5 todos from the list
		model.addAttribute("todos", todos.stream().limit(5).toArray());
		return "home";
	}

}
