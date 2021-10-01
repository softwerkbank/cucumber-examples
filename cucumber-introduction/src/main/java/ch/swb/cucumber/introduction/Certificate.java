package ch.swb.cucumber.introduction;

import java.time.LocalDate;
import java.util.Objects;

public class Certificate {

	private final String title;
	private final LocalDate date;

	public Certificate(String title, LocalDate date) {
		this.title = title;
		this.date = date;
	}

	public String title() {
		return title;
	}

	public LocalDate date() {
		return date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certificate other = (Certificate) obj;
		return Objects.equals(title, other.title);
	}

}
