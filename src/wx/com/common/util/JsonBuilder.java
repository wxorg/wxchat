package wx.com.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
   * @ClassName: JsonBuilder
   * @Description: TODO
   * @author Comsys-axin
   * @date 2013年12月31日 上午12:43:05
   *
 */
@SuppressWarnings("all")
public class JsonBuilder {
	
	private static String conmmonString = "{\"array\":%s}";

	/**
	 * 
	* @Title: getJsonFromList 
	* @Description: TODO
	* @param @param list
	* @param @return
	* @param @throws Exception   
	* @return String
	* @throws
	 */
	public static String getJsonFromList(List list) throws Exception {
		StringBuilder sBuilder = new StringBuilder();
		if (list.size() > 0) {
			Object obj = list.get(0);
			if (obj.getClass() == java.util.HashMap.class) {
				for (int i = 0; i < list.size(); i++) {
					Map map = (Map) list.get(i);
					//System.out.println("1="+i);
					sBuilder.append(getJsonFromMap(map));
					if (i + 1 < list.size())
						sBuilder.append(",");
				}
			} else {
				for (int i = 0; i < list.size(); i++) {
					sBuilder.append(genFromObj(list.get(i)));
					System.out.println("2="+i);
					if (i + 1 < list.size())
						sBuilder.append(",");
				}
			}
		}
		//System.out.println(sBuilder.toString());
		return 	String.format(conmmonString, "["+sBuilder.toString()+"]");
	}//getJsonFromList -- end
	
	
	public static String getJsonFromMap(Map map) throws Exception {
		StringBuilder sBuilder = new StringBuilder();
		//String[] arrAarry = new String[7];
		
		Iterator it = map.entrySet().iterator();
		sBuilder.append("{");
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			if (key == null)
				key = "";
			Object value = entry.getValue();
			if (value == null)
				value = "";
			
			//System.out.println(key.toString()+"===="+value.toString());
			
			sBuilder.append("\"");
			sBuilder.append(key.toString().toLowerCase());
			sBuilder.append("\"");
			sBuilder.append(":");
			sBuilder.append("\"");
			sBuilder.append(encodeJson(encodeHtml(value.toString()).replaceAll("\"", "")));
			sBuilder.append("\"");
			
			if (it.hasNext())
				sBuilder.append(",");
		}
		
		sBuilder.append("}");
		//System.out.println(sBuilder.toString());
		return encodeHtml(sBuilder.toString());
	}
	
	/**
	 * html特殊字符处理.
	 * 
	 * @param sourceString
	 *            源字符串.
	 * @return 结果字符串.
	 */
	public static String encodeHtml(String sourceString) {
		return sourceString.replace("<", "&lt;").replace(">", "&gt;");
	}

	/**
	 * html特殊字符处理.(旧版本使用)
	 * 
	 * @param sourceString
	 *            源字符串.
	 * @return 结果字符串.
	 */
	public static String EncodeHtml(String sourceString) {
		return sourceString.replace("<", "&lt;").replace(">", "&gt;")
				.replace("\\", "\\\\").replace("\r\n", "\\n")
				.replace("\n", "\\n");
	}

	/**
	 * html特殊字符反处理.
	 * 
	 * @param sourceString
	 *            源字符串.
	 * @return 结果字符串.
	 */
	public static String decodeHtml(String sourceString) {
		return sourceString.replace("&lt;", "<").replace("&gt;", ">")
				.replace("\\\\", "\\").replace("\\n", "\n");
	}

	/**
	 * generate json from obj 根据对象生成json 字符串.
	 * 
	 * @param obj
	 * @return json串.
	 */
	public static String genFromObj(Object object) throws Exception {
		StringBuilder builder = new StringBuilder();
		Object obj = object;
		Field[] fields = obj.getClass().getDeclaredFields();
		builder.append("{");
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			Method method = obj.getClass().getMethod(
					"get" + name.substring(0, 1).toUpperCase()
							+ name.substring(1), new Class[] {});
			Object result = method.invoke(obj, new Object[] {});
			builder.append("\"");
			builder.append(name.toLowerCase());
			builder.append("\"");
			builder.append(":");
			builder.append("\"");
			builder.append(encodeJson(encodeHtml(result != null ? result
					.toString() : "")));
			builder.append("\"");
			if (i + 1 < fields.length)
				builder.append(",");
		}
		builder.append("}");
		return encodeHtml(builder.toString());

	}
	
	static String encodeJson(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			switch (c) {
			case '\"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '/':
				sb.append("\\/");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			default:
				sb.append(c);
			}
		}
		return sb.toString();
	}
}//JsonBuilder
