package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddController {

	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("addModel", new AddModel());
		return "add";
	}

	@PostMapping("/add")
	public String add(AddModel addModel, Model model) {
		System.out.println(addModel.getFirst());
		addModel.setResult(addModel.getFirst() + addModel.getSecond());
		model.addAttribute("addModel", addModel);
		return "add";
	}
}
