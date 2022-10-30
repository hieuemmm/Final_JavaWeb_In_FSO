/**
 * 
 */
package fa.training.utils;

import java.sql.Timestamp;

/**
 * @author ADMIN
 *
 */
public class DateUtil {
	/**
	 * @Authour : Fa.training
	 * @Birthday : YYYY-MM-DD
	 */
	public static String getTimeStamp() {
		return new Timestamp(System.currentTimeMillis()).toString().replaceAll("-", "").replaceAll(":", "");
	}
}
