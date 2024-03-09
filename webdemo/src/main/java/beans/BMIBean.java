package beans;

// JavaBean
public class BMIBean {
	private double height, weight;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	// type property 
	public String getType() {
		double bmi = getBMI();

		if (bmi < 18.5)
			return "Underweigth";
		else if (bmi < 25)
			return "Normal";
		else if (bmi < 30)
			return "Overweight";
		else
			return "Obesse";

	}
	
	// BMI property
	public double getBMI() {
		 return this.weight / (this.height * this.height);
	}

}
