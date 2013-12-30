package wx.com.common;

/**
 * 
   * @ClassName: StringFormat
   * @Description: TODO
   * @author Comsys-axin
   * @date 2013年12月28日 下午10:13:44
   *
 */
public class StringFormat {

	/**
	 * String format
	 * 根据后面传的参数格式化第一个参数的字符串.
	 * @param str
	 * @param args
	 * @return 格式化后的字符串.
	 */
	public static String format(String str, Object... args) {
		if (str == null || "".equals(str))
			return "";
		if (args.length == 0) {
			return str;
		}
		String result = str;
		java.util.regex.Pattern p = java.util.regex.Pattern
				.compile("\\{(\\d+:{0,1}@{0,1}\\w*)\\}");
		java.util.regex.Matcher m = p.matcher(str);

		while (m.find()) {
			int index = Integer.parseInt(m.group(1));
			if (index < args.length) {
				result = result.replace(m.group(), args[index].toString());
			}
		}
		return result;
	}

	/**
	 * 格式化危险字符
	 * 
	 * @param str
	 * @param args
	 * @return 格式化后的字符串.
	 */
	public static String replaceFilter(String str, Object... args) {
		if (str == null || "".equals(str))
			return "";
		if (args.length == 0) {
			return str;
		}
		try {
			if (args.length % 2 == 0) {
				for (int i = 0; i < args.length; i += 2) {
					str = str.replace(args[i].toString(), args[i + 1]
							.toString());
				}
			}
		} catch (Exception ex) {
			// System.out.println(ex.getMessage());

		}
		return str;
	}

}
