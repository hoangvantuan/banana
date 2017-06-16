package banana.util.string;

public class StringUtil {

	public static final String STR_EMPTY = "";

	public static boolean isValue(String str) {
		return str != null && !str.equals(STR_EMPTY);
	}
}
