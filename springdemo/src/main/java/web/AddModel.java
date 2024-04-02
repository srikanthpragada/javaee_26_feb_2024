package web;

import jakarta.validation.constraints.Min;

public class AddModel {
	private int first, second, result;

	@Min(value=1,message = "Invalid First Number. It must be > 0")
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	@Min(value=1,message = "Invalid Second Number. It must be > 0")
	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
