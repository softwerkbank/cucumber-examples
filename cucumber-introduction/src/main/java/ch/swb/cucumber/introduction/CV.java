package ch.swb.cucumber.introduction;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CV {

	private final Set<Certificate> certificates = new HashSet<>();

	public void addCertifcate(String title, LocalDate date) {
		certificates.add(new Certificate(title, date));
	}

	public Optional<Certificate> findByTitle(String title) {
		return certificates.stream()
				.filter(certificate -> certificate.title().equalsIgnoreCase(title))
				.findFirst();
	}

	public int countCertificates() {
		return certificates.size();
	}

}
