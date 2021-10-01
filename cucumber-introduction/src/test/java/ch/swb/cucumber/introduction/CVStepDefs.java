package ch.swb.cucumber.introduction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

public class CVStepDefs implements En {

	private CV cv;

	public CVStepDefs() {
		// StepDefs with Java 8 Lambda syntax

		Given("An empty CV", () -> cv = new CV());

		Given("CV contains the following employments:", (DataTable employmentsTable) -> {
			List<Map<String, String>> employments = employmentsTable.asMaps();
			employments.forEach(employment -> {
				String employer = employment.get("employer");
				LocalDate startDate = convertToLocalDate(employment.get("from"));
				LocalDate endDate = convertToLocalDate(employment.get("to"));
				cv.addEmployment(employer, startDate, endDate);
			});
		});

		When("I add the certificate {string} that I received on {date} to my CV", (String title, LocalDate date) -> {
			cv.addCertifcate(title, date);
		});

		When("I add an employment at {string} starting on {date} until {date}", (String employer, LocalDate startDate, LocalDate endDate) -> {
			cv.addEmployment(employer, startDate, endDate);
		});

		When("I remove the certificate {string}", (String title) -> {
			cv.removeCertificate(title);
		});

		Then("My CV contains the certificate {string}", (String title) -> {
			Optional<Certificate> certificate = cv.findCertificateByTitle(title);
			assertTrue(certificate.isPresent());
			assertEquals(title, certificate.get().title());
		});

		Then("The period of the employment at {string} is {int} year(s) and {int} month(s)", (String employer, Integer nrOfYears, Integer nrOfMonths) -> {
			Optional<Employment> employment = cv.findEmploymentByEmployer(employer);
			assertTrue(employment.isPresent());
			assertEquals(Period.of(nrOfYears, nrOfMonths, 0), employment.get().calculateEmploymentPeriod());
		});

	}

	@ParameterType(value = "today|\\d\\d\\d\\d-\\d\\d-\\d\\d", name = "date")
	public LocalDate convertToLocalDate(String date) {
		if (date.equalsIgnoreCase("today")) {
			LocalDate now = LocalDate.now();
			return now.with(TemporalAdjusters.lastDayOfMonth());
		}
		return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	// StepDefs without Lambdas
	@Given("CV contains certificate {string} with date {date}")
	public void cv_contains_certificate(String title, LocalDate date) {
		cv.addCertifcate(title, date);
	}

	@Then("My CV contains {int} certificate(s)")
	public void cv_contains_number_certificates(int numberOfCertificates) {
		assertEquals(numberOfCertificates, cv.countCertificates());
	}

}
