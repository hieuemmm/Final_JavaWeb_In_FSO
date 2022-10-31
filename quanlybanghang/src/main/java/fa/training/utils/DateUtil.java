/**
 * @Authour : ThoPP
 * @Birthday : 1992-08-26
 */
package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @Authour : ThoPP
 * @Birthday : 1992-08-26
 */
public class DateUtil {
	private static SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm");

	/**
	 * @Authour : ThoPP
	 * @Birthday : 1992-08-26
	 */
	public static String toDayOfWeek(String dateString) {
		String date = String.valueOf(dateString);
		LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
		switch (dayOfWeek.name().toLowerCase()) {
		case "monday":
			return "T2";
		case "tuesday":
			return "T3";
		case "wednesday":
			return "T4";
		case "thursday":
			return "T5";
		case "friday":
			return "T6";
		case "saturday":
			return "T7";
		case "sunday":
			return "CN";
		}
		return "";
	}

	/**
	 * @Authour : ThoPP
	 * @Birthday : 1992-08-26
	 */
	public static int compareToDate(String dateString1, String dateString2) {
		Date date1 = toDate(dateString1);
		Date date2 = toDate(dateString2);
		return date1.compareTo(date2);
	}

	/**
	 * @Authour : ThoPP
	 * @Birthday : 1992-08-26
	 */
	public static int compareToTime(String timeString1, String timeString2) {
		Date date1 = toTime(timeString1);
		Date date2 = toTime(timeString2);
		return date1.compareTo(date2);
	}

	/**
	 * @Authour : ThoPP
	 * @Birthday : 1992-08-26
	 * @return
	 */
	private static Date toDate(String dateString) {
		try {
			return simpleDateFormatDate.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * @Authour : ThoPP
	 * @Birthday : 1992-08-26
	 */
	private static Date toTime(String timeString) {
		try {
			return simpleDateFormatTime.parse(timeString);
		} catch (ParseException e) {
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(toDayOfWeek("2022-10-31"));
	}
}
