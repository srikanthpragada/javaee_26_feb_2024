package ioc;

import java.util.List;

import org.springframework.stereotype.Component;

//@Component
public class PythonBooks implements BooksCatalog {

	public PythonBooks() {
		System.out.println("PythonBooks()");
	}
	@Override
	public List<String> getBooks() {
		   return  List.of("Python Tricks", "Basics of Python");
	}
	

}
