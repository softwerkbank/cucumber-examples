package ch.swb.cucumber.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java8.En;

public class CalculatorAdditionStepDefs implements En {

	private Map<String, Integer> numbers = new HashMap<>();
	private Calculator calculator;

	public CalculatorAdditionStepDefs() {
		Given("^number (\\w) with value (\\d)", (String numberAlias, Integer value) -> numbers.put(numberAlias, value));

		When("^add number (\\w) and (\\w)", (String firstNumberAlias, String secondNumberAlias) -> {
			calculator = new Calculator();
			calculator.add(numbers.get(firstNumberAlias), numbers.get(secondNumberAlias));
		});

		Then("^result is (\\d)", (Integer result) -> {
			assertEquals(result, calculator.getResult());
		});
	}

}
