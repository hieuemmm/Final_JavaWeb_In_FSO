/**
 * 
 */
package fa.training.utils;

import java.sql.Timestamp;

public class UUID_Util {
	/**
	 * @param prefix 
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public static String getNumber(String prefix, int length) {
		return prefix + new Timestamp(System.currentTimeMillis())
		.toString().replace("-", "")
		.replace(":", "")
		.replace(".", "")
		.replace(" ", "")
		.substring(17 - length - prefix.length(), 17)//length == 7 => (10,17)
		.trim();
	}
}
