package basics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "departments")
@Entity(name="basics.Department")
public class Department {
	@Id // primary key
	@Column(name = "department_id")
	private int id;

	@Column(name = "department_name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
