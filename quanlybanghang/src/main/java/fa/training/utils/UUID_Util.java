/**
 * 
 */
package fa.training.utils;

import java.sql.Timestamp;

public class UUID_Util {
	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public static String getTimeStamp() {
		return new Timestamp(System.currentTimeMillis())
		.toString().replace("-", "")
		.replace(":", "")
		.replace(".", "")
		.replace(" ", "")
		.substring(9,17);
	}
}
