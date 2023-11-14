package christmas.util;

public class Util {
	public static boolean startsWithComma(String str) {
		if (str.startsWith(",")) {
			return true;
		}
		return false;
	}

	public static boolean endsWithComma(String str) {
		if (str.endsWith(",")) {
			return true;
		}
		return false;
	}

	public static boolean startsWithDash(String str) {
		if (str.startsWith("-")) {
			return true;
		}
		return false;
	}

	public static boolean endsWithDash(String str) {
		if (str.endsWith("-")) {
			return true;
		}
		return false;
	}

	public static int getTokenSize(String str, String del) {
		String[] tokens = str.split(del);
		return tokens.length;
	}

	public static boolean isDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
}
