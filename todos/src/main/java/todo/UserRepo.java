package todo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo  extends CrudRepository<TodoUser,String> {
	
	  

}
