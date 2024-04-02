package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import web.data.DeptRepo;

@Controller 
public class DeptController {
	@Autowired 
	private DeptRepo  deptRepo;
	
	
	@GetMapping("/depts")
	public String  getDepts(Model model) {
		
		model.addAttribute("depts", deptRepo.findAll());
		return "listdept";
	}
	  
}
