package banana.util.string;

public class StringUtil {

	public static boolean isValue(String str) {
		return str != null && str.length() > 0;
	}

	public static boolean isNull(String str) {
		return !StringUtil.isValue(str);
	}
}
