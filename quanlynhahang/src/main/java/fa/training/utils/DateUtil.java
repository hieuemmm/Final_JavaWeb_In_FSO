/**
 * @Authour : HieuVV4
 * @Birthday : 2000-08-26
 */
package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @Authour : HieuVV4
 * @Birthday : 2000-08-26
 */
public class DateUtil {
	private static SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm");

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public static String toDayOfWeek(String dateString) {
		Date date1 = toDate(dateString);
		int date = date1.getDate();
		int month = date1.getMonth();
		int year = date1.getYear();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, date);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		Date myDay = calendar.getTime();
		String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(myDay);

		switch (dayOfWeek) {
		case "Monday":
			return "T4";
		case "Tuesday":
			return "T5";
		case "Wednesday":
			return "T6";
		case "Thursday":
			return "T7";
		case "Friday":
			return "CN";
		case "Saturday":
			return "T2";
		case "Sunday":
			return "T3";
		}
		return dayOfWeek;
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public static int compareToDate(String dateString1, String dateString2) {
		Date date1 = toDate(dateString1);
		Date date2 = toDate(dateString2);
		return date1.compareTo(date2);
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public static int compareToTime(String timeString1, String timeString2) {
		Date date1 = toTime(timeString1);
		Date date2 = toTime(timeString2);
		return date1.compareTo(date2);
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
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
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	private static Date toTime(String timeString) {
		try {
			return simpleDateFormatTime.parse(timeString);
		} catch (ParseException e) {
			return null;
		}
	}

}
