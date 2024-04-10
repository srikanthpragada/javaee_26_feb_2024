package todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "todousers")
public class TodoUser {
	@Id
	@Column(length = 10)
	private String username;

	@Column(length = 10)
	private String password;

	@Transient
	private String confirmPassword;

	@Column(length = 50)
	private String email;

	@OneToMany(mappedBy = "username")
	private List<Todo> todos = new ArrayList<Todo>();

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public String getUsername() {
		return username;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDetails asUser() {
		// convert TodoUser to UserDetails
		return User.withDefaultPasswordEncoder() //
				.username(getUsername()) //
				.password(getPassword()) //
				.authorities("USER") //
				.build();
	}

}
