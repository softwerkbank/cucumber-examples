package ch.swb.cucumber.example;

public class Calculator {
	private Integer result = 0;

	public void add(Integer firstNumber, Integer secondNumber) {
		result = firstNumber + secondNumber;
	}

	public Integer getResult() {
		return result;
	}

}
