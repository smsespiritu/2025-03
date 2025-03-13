package projTest;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class DateTime {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		LocalDate startDate = LocalDate.of(2017, 1, 1);
		LocalDate endDate = LocalDate.of(2017, 3, 1);
		Period period = Period.between(startDate, endDate);
		System.out.println(period.getDays());

	}

}
