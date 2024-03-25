package jdbc;

public class DeptTotalSalary {
	private String name;
	private int totalSalary;

	public DeptTotalSalary(String name, int totalSalary) {
		super();
		this.name = name;
		this.totalSalary = totalSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}

}
