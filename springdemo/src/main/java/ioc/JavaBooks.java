package ioc;

import java.util.List;

import org.springframework.stereotype.Component;

//@Component
public class JavaBooks implements BooksCatalog {

	public JavaBooks() {
		System.out.println("JavaBooks()");
	}
	@Override
	public List<String> getBooks() {
		   return  List.of("Java Comp. Ref", "Java Persistence with Hibernate");
	}
	

}
