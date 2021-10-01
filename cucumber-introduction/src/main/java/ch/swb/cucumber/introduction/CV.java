package ch.swb.cucumber.introduction;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CV {

	private final Set<Certificate> certificates = new HashSet<>();
	private final Set<Employment> employments = new HashSet<>();

	public void addCertifcate(String title, LocalDate date) {
		certificates.add(new Certificate(title, date));
	}

	public void removeCertificate(String title) {
		certificates.removeIf(certificate -> certificate.title().equalsIgnoreCase(title));

	}

	public Optional<Certificate> findCertificateByTitle(String title) {
		return certificates.stream()
				.filter(certificate -> certificate.title().equalsIgnoreCase(title))
				.findFirst();
	}

	public int countCertificates() {
		return certificates.size();
	}

	public void addEmployment(String employer, LocalDate startDate, LocalDate endDate) {
		employments.add(new Employment(employer, startDate, endDate));
	}

	public Optional<Employment> findEmploymentByEmployer(String employer) {
		return employments.stream()
				.filter(employment -> employment.getEmployer().equalsIgnoreCase(employer))
				.findFirst();
	}

}
