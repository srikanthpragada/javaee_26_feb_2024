package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Test implements CommandLineRunner {
	@Autowired
	//@Qualifier("pythonBooks")
	BooksCatalog catalog;
	
 
	BooksCatalog books;

	public Test(BooksCatalog books) {
		this.books = books;
		System.out.println("Test()");
		System.out.println(catalog);
		System.out.println(this.books);
	}
	
	@PostConstruct 
	public void init() {
		System.out.println(catalog);
	}

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(catalog.hashCode());
		System.out.println(books.hashCode());
		
		for (var book : catalog.getBooks())
			System.out.println(book);

	}

}
