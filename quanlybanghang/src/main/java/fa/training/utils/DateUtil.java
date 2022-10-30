/**
 * @Authour : HieuVV4
 * @Birthday : 2000-08-26
 */
package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Authour : HieuVV4
 * @Birthday : 2000-08-26
 */
public class DateUtil {
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public static int compareTo(String dateString1, String dateString2) {
		Date date1 = toDate(dateString1);
		Date date2 = toDate(dateString2);
		return date1.compareTo(date2);
	}

	/**
	 * @return
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	private static Date toDate(String dateString) {
		try {
			return simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}
}
