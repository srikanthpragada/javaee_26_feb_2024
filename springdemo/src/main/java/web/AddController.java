package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class AddController {

	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("addModel", new AddModel());
		return "add";
	}

	@PostMapping("/add")
	public String add(@Valid AddModel addModel, BindingResult result, Model model) {
		
		
		if(result.hasErrors()) {
			model.addAttribute("message", result.getAllErrors().get(0).getDefaultMessage());
		    addModel.setResult(0);   
		}
		else 
		{
		    addModel.setResult(addModel.getFirst() + addModel.getSecond());
		    model.addAttribute("message", "");
		}
		
		model.addAttribute("addModel", addModel);
		return "add";
	}
}
