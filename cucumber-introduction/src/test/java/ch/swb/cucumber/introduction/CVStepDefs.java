package ch.swb.cucumber.introduction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

public class CVStepDefs implements En {

	private CV cv;

	public CVStepDefs() {
		// StepDefs with Java 8 Lambda syntax

		Given("An empty CV", () -> cv = new CV());

		When("I add the certificate {string} that I received on {date} to my CV", (String title, LocalDate date) -> {
			cv.addCertifcate(title, date);
		});

		Then("My CV contains the certificate {string}", (String title) -> {
			Optional<Certificate> result = cv.findByTitle(title);
			assertTrue(result.isPresent());
			assertEquals(title, result.get().title());
		});

		ParameterType("date", "\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d", (String date) -> LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
	}

	// StepDefs without Lambdas

	@Given("CV contains certificate {string} with date {date}")
	public void cv_contains_certificate(String title, LocalDate date) {
		cv.addCertifcate(title, date);
	}

	@Then("My CV contains {int} certificates")
	public void cv_contains_number_certificates(int numberOfCertificates) {
		assertEquals(numberOfCertificates, cv.countCertificates());
	}

}
