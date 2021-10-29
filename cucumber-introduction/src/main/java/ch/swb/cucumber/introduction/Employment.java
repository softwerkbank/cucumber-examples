package ch.swb.cucumber.introduction;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.util.Objects;

public class Employment {
	private final String employer;
	private final LocalDate startDate;
	private final LocalDate endDate;

	public Employment(String employer, LocalDate startDate, LocalDate endDate) {
		this.employer = employer;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getEmployer() {
		return employer;
	}

	public Period calculateEmploymentPeriod() {
		return Period.between(startDate.with(TemporalAdjusters.firstDayOfMonth()), endDate.with(TemporalAdjusters.firstDayOfNextMonth()));
	}

	@Override
	public int hashCode() {
		return Objects.hash(employer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employment other = (Employment) obj;
		return Objects.equals(employer, other.employer);
	}

}
