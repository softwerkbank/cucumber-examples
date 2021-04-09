package ch.swb.cucumber.introduction;

import java.time.LocalDate;

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

}
