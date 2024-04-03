package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import web.data.Department;
import web.data.DeptRepo;
import web.data.EmployeeRepo;

@Controller 
public class DeptController {
	@Autowired 
	private DeptRepo  deptRepo;
	
	@Autowired 
	private EmployeeRepo  empRepo;
	
	@GetMapping("/depts")
	public String  getDepts(Model model) {
		model.addAttribute("depts", deptRepo.findAll());
		return "listDepts";
	}
	
	@GetMapping("/addDept")
	public String  addForm(Model model) {
		Department d = new Department();
		model.addAttribute("dept", d);
		return "addDept";
	}
	
	@PostMapping("/addDept")
	public String  addForm(Department dept, Model model) {
		deptRepo.save(dept);
		return "redirect:depts";
	}
	
	
	@GetMapping("/delete")
	public String deleteDept(int id) {
		deptRepo.deleteById(id);
		return "redirect:depts";
	}
	
	
	@GetMapping("/edit")
	public String editDept(int id, Model model) {
	    var optDept = deptRepo.findById(id);
	    if (optDept.isPresent()) {
		     model.addAttribute("dept", optDept.get());
		     return "editDept";
	    }
	    else
	    	return "redirect:depts";
	}
	
	
	@PostMapping("/edit")
	public String updateDept(Department dept, Model model) {
	    var optDept = deptRepo.findById(dept.getId());
	    if (optDept.isPresent()) {
		     Department d = optDept.get();
		     d.setName(dept.getName());
		     deptRepo.save(d);
		     return "redirect:depts";
	    }
	    else
	    	return "redirect:depts";
	}
	
	
	@GetMapping("/employees")
	public String  listEmployees(int dept, Model model) {
		var employees = empRepo.findByDeptId(dept);
		model.addAttribute("employees", employees);
		model.addAttribute("deptId", dept);
		return "listEmployees";
	}
	
	
	
	  
}
