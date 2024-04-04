package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		model.addAttribute("message", "");
		Department d = new Department();
		model.addAttribute("dept", d);
		return "addDept";
	}
	
	@PostMapping("/addDept")
	public String  addForm(Department dept, Model model) {
		// Is dept_id unique 
		var optDept = deptRepo.findById(dept.getId());
		if (optDept.isEmpty())
		{
		  deptRepo.save(dept);  // insert 
		  return "redirect:depts";
		}
		else
		{
			model.addAttribute("message", "Department Id Already Exists!");
			model.addAttribute("dept", dept);
			return "addDept";
		}
	}
	
	
	@GetMapping("/exists")
	@ResponseBody
	public String deptExists(int id) {
		var optDept = deptRepo.findById(id);
		if (optDept.isPresent())
			return "1"; // existing
		else
			return "0"; // not existing 
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
	    else {
	    	return "editError";
	    }
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
		var optDept = deptRepo.findById(dept);
		model.addAttribute("deptName", optDept.get().getName());
		
		model.addAttribute("employees", employees);
		model.addAttribute("deptId", dept);
		return "listEmployees";
	}
	
	
	@GetMapping("/searchEmployees")
	public String  searchEmployees() {
		return "searchEmployees";
	}
	
	@GetMapping("/doSearch")
	public String  searchEmployees(String empName, Model model) {
		// get Employees by the given name 
		var employees = empRepo.findByNameContaining(empName);
		model.addAttribute("empName", empName);
		model.addAttribute("employees", employees);
		return "searchEmployees";
	}
	
	
	  
}
