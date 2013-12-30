package wx.com.common;

/**
 * 
   * @ClassName: StringFormatSQL
   * @Description: TODO
   * @author Comsys-axin
   * @date 2013年12月28日 下午10:14:19
   *
 */

public class StringFormatSQL extends StringFormat {

	private static String p1 = "\\{(\\d+)\\}";
	private static String p2 = "like\\s+'(%|_*)\\{(\\d+)\\}(%|_*)'";
	private static String p3 = " escape '/'";

	/**
	 * 通用过滤特殊字符方法[单引号]
	 * 
	 * @param sourceString
	 * @return 过滤后的字符串.
	 */
	private static String FilterCommon(String sourceString) {
		if (sourceString.trim().length() == 0) {
			return null;
		}// 长度判断
		return sourceString.replace("'", "''");
	}

	/**
	 * 过滤Like中的特殊字符[主要是转义字符]
	 * 
	 * @param sourceString
	 * @return 过滤后的字符串.
	 */
	private static String FilterLike(String sourceString) {
		if (!"".equals(sourceString)) {
			String temp = FilterCommon(sourceString);// 通用过滤
			temp = temp.replace("/", "//");
			temp = temp.replace("[", "/[");
			temp = temp.replace("%", "/%");
			temp = temp.replace("_", "/_");
			temp = temp.replace("&", "'||chr(ascii('&'))||'");
			return temp.toString();
		} else {
			return "";
		}
	}

	/**
	 * String format
	 * 
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
		String result1, result2, resault = str;
		java.util.regex.Pattern pLike = java.util.regex.Pattern.compile(p2);
		java.util.regex.Matcher m = pLike.matcher(str);

		while (m.find()) {
			result1 = m.group();
			//System.out.println("result1:"+result1);
			java.util.regex.Pattern pLike1 = java.util.regex.Pattern
					.compile(p1);
			java.util.regex.Matcher m1 = pLike1.matcher(result1);
			m1.find();
			int index = Integer.parseInt(m1.group(1));
			String temp = FilterLike(args[index].toString());
			result2 = result1.replace(m1.group(), temp);
			result2 = result2 + p3;
			resault = resault.replace(result1, result2);
		}

		java.util.regex.Pattern pLike3 = java.util.regex.Pattern.compile(p1);
		java.util.regex.Matcher m3 = pLike3.matcher(resault);
		while (m3.find()) {
			int index = Integer.parseInt(m3.group(1));
			if (index < args.length) {				
				resault = resault.replace(m3.group(), args[index].toString());
				//System.out.println("resault:"+resault);
			}
		}
		return resault;
	}
}