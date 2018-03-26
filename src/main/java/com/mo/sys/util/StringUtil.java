package com.mo.sys.util;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * Java表单验证工具类
 * 
 * @author qb
 * 
 */
public class StringUtil {
	/**
	 * 锁对象，可以为任意对象
	 */
	private static Object lockObj = "lockerOrder";
	
	/**
	 * 订单号生成计数器
	 */
	private static long orderNumCount = 0L;
	
	/**
	 * 每毫秒生成订单号数量最大值
	 */
	private static int maxPerMSECSize = 1000;

	public final static boolean isNull(Object[] objs) {
		return (objs == null || objs.length == 0);
	}

	public final static boolean isNull(Integer integer) {
		return (integer == null || integer == 0);
	}

	public final static boolean isNull(Collection<?> collection) {
		return (collection == null || collection.size() == 0);
	}

	public final static boolean isNull(Map<?, ?> map) {
		return (map == null || map.size() == 0);
	}

	public final static boolean isNull(String str) {
		return str == null || "".equals(str.trim()) || "null".equals(str.toLowerCase());
	}

	public final static boolean isNull(Long longs) {
		return (longs == null || longs == 0);
	}

	public final static boolean isNotNull(Long longs) {
		return !isNull(longs);
	}

	public final static boolean isNull(Double db) {
		return (db == null || db == 0);
	}

	public final static boolean isNotNull(Double db) {
		return !isNull(db);
	}

	public final static boolean isNotNull(String str) {
		return !isNull(str);
	}

	public final static boolean isNotNull(Collection<?> collection) {
		return !isNull(collection);
	}

	public final static boolean isNotNull(Map<?, ?> map) {
		return !isNull(map);
	}

	public final static boolean isNotNull(Integer integer) {
		return !isNull(integer);
	}

	public final static boolean isNotNull(Object[] objs) {
		return !isNull(objs);
	}

	/**
	 * 匹配URL地址
	 * 
	 * @param str
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isUrl(String str) {
		return match(str, "^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$");
	}

	/**
	 * 匹配密码，以字母开头，长度在6-12之间，只能包含字符、数字和下划线。
	 * 
	 * @param str
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isPwd(String str) {
		return match(str, "^[a-zA-Z]\\w{6,12}$");
	}

	/**
	 * 验证字符，只能包含中文、英文、数字、下划线等字符。
	 * 
	 * @param str
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean stringCheck(String str) {
		return match(str, "^[a-zA-Z0-9\u4e00-\u9fa5-_]+$");
	}

	/**
	 * 匹配Email地址
	 * 
	 * @param str
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isEmail(String str) {
		return match(str, "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
	}

	/**
	 * 匹配非负整数（正整数+0）
	 * 
	 * @param str
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isInteger(String str) {
		return match(str, "^[+]?\\d+$");
	}

	/**
	 * 判断数值类型，包括整数和浮点数
	 * 
	 * @param str
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isNumeric(String str) {
		if (isFloat(str) || isInteger(str))
			return true;
		return false;
	}

	/**
	 * 只能输入数字
	 * 
	 * @param str
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isDigits(String str) {
		return match(str, "^[0-9]*$");
	}

	/**
	 * 匹配正浮点数
	 * 
	 * @param str
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isFloat(String str) {
		return match(str, "^[-\\+]?\\d+(\\.\\d+)?$");
	}

	/**
	 * 联系电话(手机/电话皆可)验证
	 * 
	 * @param text
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isTel(String text) {
		if (isMobile(text) || isPhone(text))
			return true;
		return false;
	}

	/**
	 * 电话号码验证
	 * 
	 * @param text
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isPhone(String text) {
		return match(text, "^(\\d{3,4}-?)?\\d{7,9}$");
	}

	/**
	 * 手机号码验证
	 * 
	 * @param text
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isMobile(String text) {
		if (text.length() != 11)
			return false;
		return match(text, "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
	}

	/**
	 * 身份证号码验证
	 * 
	 * @param text
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isIdCardNo(String text) {
		return match(text, "^(\\d{6})()?(\\d{4})(\\d{2})(\\d{2})(\\d{3})(\\w)$");
	}

	/**
	 * 邮政编码验证
	 * 
	 * @param text
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isZipCode(String text) {
		return match(text, "^[0-9]{6}$");
	}

	/**
	 * 判断整数num是否等于0
	 * 
	 * @param num
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isIntEqZero(int num) {
		return num == 0;
	}

	/**
	 * 判断整数num是否大于0
	 * 
	 * @param num
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isIntGtZero(int num) {
		return num > 0;
	}

	/**
	 * 判断整数num是否大于或等于0
	 * 
	 * @param num
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isIntGteZero(int num) {
		return num >= 0;
	}

	/**
	 * 判断浮点数num是否等于0
	 * 
	 * @param num
	 *            浮点数
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isFloatEqZero(float num) {
		return num == 0f;
	}

	/**
	 * 判断浮点数num是否大于0
	 * 
	 * @param num
	 *            浮点数
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isFloatGtZero(float num) {
		return num > 0f;
	}

	/**
	 * 判断浮点数num是否大于或等于0
	 * 
	 * @param num
	 *            浮点数
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isFloatGteZero(float num) {
		return num >= 0f;
	}

	/**
	 * 判断是否为合法字符(a-zA-Z0-9-_)
	 * 
	 * @param text
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isRightfulString(String text) {
		return match(text, "^[A-Za-z0-9_-]+$");
	}

	/**
	 * 判断英文字符(a-zA-Z)
	 * 
	 * @param text
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isEnglish(String text) {
		return match(text, "^[A-Za-z]+$");
	}

	/**
	 * 判断中文字符(包括汉字和符号)
	 * 
	 * @param text
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isChineseChar(String text) {
		return match(text, "^[\u0391-\uFFE5]+$");
	}

	/**
	 * 匹配汉字
	 * 
	 * @param text
	 * @return
	 * @author jiqinlin
	 */
	public final static boolean isChinese(String text) {
		return match(text, "^[\u4e00-\u9fa5]+$");
	}

	/**
	 * 是否包含中英文特殊字符，除英文"-_"字符外
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isContainsSpecialChar(String text) {
		if (StringUtils.isBlank(text))
			return false;
		String[] chars = { "[", "`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "+", "=", "|", "{", "}",
				"'", ":", ";", "'", ",", "[", "]", ".", "<", ">", "/", "?", "~", "！", "@", "#", "￥", "%", "…", "&", "*",
				"（", "）", "—", "+", "|", "{", "}", "【", "】", "‘", "；", "：", "”", "“", "’", "。", "，", "、", "？", "]" };
		for (String ch : chars) {
			if (text.contains(ch))
				return true;
		}
		return false;
	}

	/**
	 * 过滤中英文特殊字符，除英文"-_"字符外
	 * 
	 * @param text
	 * @return
	 */
	public static String stringFilter(String text) {
		String regExpr = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regExpr);
		Matcher m = p.matcher(text);
		return m.replaceAll("").trim();
	}

	/**
	 * 过滤html代码
	 * 
	 * @param inputString
	 *            含html标签的字符串
	 * @return
	 */
	public static String htmlFilter(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		java.util.regex.Pattern p_ba;
		java.util.regex.Matcher m_ba;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			String patternStr = "\\s+";

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			p_ba = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
			m_ba = p_ba.matcher(htmlStr);
			htmlStr = m_ba.replaceAll(""); // 过滤空格

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;// 返回文本字符串
	}

	/**
	 * 正则表达式匹配
	 * 
	 * @param text
	 *            待匹配的文本
	 * @param reg
	 *            正则表达式
	 * @return
	 * @author jiqinlin
	 */
	private final static boolean match(String text, String reg) {
		if (StringUtils.isBlank(text) || StringUtils.isBlank(reg))
			return false;
		return Pattern.compile(reg).matcher(text).matches();
	}

	// 参考地址：http://www.cnblogs.com/yansheng/archive/2010/05/07/1730188.html

	// 附 ： 常用的正则表达式：
	// 匹配特定数字：
	// ^[1-9]d*$ //匹配正整数
	// ^-[1-9]d*$ //匹配负整数
	// ^-?[1-9]d*$ //匹配整数
	// ^[1-9]d*|0$ //匹配非负整数（正整数 + 0）
	// ^-[1-9]d*|0$ //匹配非正整数（负整数 + 0）
	// ^[1-9]d*.d*|0.d*[1-9]d*$ //匹配正浮点数
	// ^-([1-9]d*.d*|0.d*[1-9]d*)$ //匹配负浮点数
	// ^-?([1-9]d*.d*|0.d*[1-9]d*|0?.0+|0)$ //匹配浮点数
	// ^[1-9]d*.d*|0.d*[1-9]d*|0?.0+|0$ //匹配非负浮点数（正浮点数 + 0）
	// ^(-([1-9]d*.d*|0.d*[1-9]d*))|0?.0+|0$ //匹配非正浮点数（负浮点数 + 0）
	// 评注：处理大量数据时有用，具体应用时注意修正
	//
	// 匹配特定字符串：
	// ^[A-Za-z]+$ //匹配由26个英文字母组成的字符串
	// ^[A-Z]+$ //匹配由26个英文字母的大写组成的字符串
	// ^[a-z]+$ //匹配由26个英文字母的小写组成的字符串
	// ^[A-Za-z0-9]+$ //匹配由数字和26个英文字母组成的字符串
	// ^w+$ //匹配由数字、26个英文字母或者下划线组成的字符串
	//
	// 在使用RegularExpressionValidator验证控件时的验证功能及其验证表达式介绍如下:
	//
	// 只能输入数字：“^[0-9]*$”
	// 只能输入n位的数字：“^d{n}$”
	// 只能输入至少n位数字：“^d{n,}$”
	// 只能输入m-n位的数字：“^d{m,n}$”
	// 只能输入零和非零开头的数字：“^(0|[1-9][0-9]*)$”
	// 只能输入有两位小数的正实数：“^[0-9]+(.[0-9]{2})?$”
	// 只能输入有1-3位小数的正实数：“^[0-9]+(.[0-9]{1,3})?$”
	// 只能输入非零的正整数：“^+?[1-9][0-9]*$”
	// 只能输入非零的负整数：“^-[1-9][0-9]*$”
	// 只能输入长度为3的字符：“^.{3}$”
	// 只能输入由26个英文字母组成的字符串：“^[A-Za-z]+$”
	// 只能输入由26个大写英文字母组成的字符串：“^[A-Z]+$”
	// 只能输入由26个小写英文字母组成的字符串：“^[a-z]+$”
	// 只能输入由数字和26个英文字母组成的字符串：“^[A-Za-z0-9]+$”
	// 只能输入由数字、26个英文字母或者下划线组成的字符串：“^w+$”
	// 验证用户密码:“^[a-zA-Z]\\w{5,17}$”正确格式为：以字母开头，长度在6-18之间，
	//
	// 只能包含字符、数字和下划线。
	// 验证是否含有^%&’,;=?$”等字符：“[^%&’,;=?$x22]+”
	// 只能输入汉字：“^[u4e00-u9fa5],{0,}$”
	// 验证Email地址：“^w+[-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*$”
	// 验证InternetURL：“^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$”
	// 验证电话号码：“^((d{3,4})|d{3,4}-)?d{7,8}$”
	//
	// 正确格式为：“XXXX-XXXXXXX”，“XXXX-XXXXXXXX”，“XXXXXXX”，
	//
	// “XXXXXXXX”，“XXXXXXX”，“XXXXXXXX”。
	// 验证身份证号（15位或18位数字）：“^d{15}|d{}18$”
	// 验证一年的12个月：“^(0?[1-9]|1[0-2])$”正确格式为：“01”-“09”和“1”“12”
	// 验证一个月的31天：“^((0?[1-9])|((1|2)[0-9])|30|31)$” 正确格式为：“01”“09”和“1”“31”。
	//
	// 匹配中文字符的正则表达式： [u4e00-u9fa5]
	// 匹配双字节字符(包括汉字在内)：[^x00-xff]
	// 匹配空行的正则表达式：n[s| ]*r
	// 匹配HTML标记的正则表达式：/< (.*)>.*|< (.*) />/
	// 匹配首尾空格的正则表达式：(^s*)|(s*$)
	// 匹配Email地址的正则表达式：w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*
	// 匹配网址URL的正则表达式：^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$
	/**
	 * 将DATE格式时间转换成字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String dataToStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		return sdf.format(date);
	}

	/**
	 * 字符串转换成日期,yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param str
	 * @return date
	 */
	public static Date strToDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取当前的时间的str， yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getNowDataStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		return sdf.format(new Date());
	}

	/**
	 * 获取获取当天结束时间的str， yyyy-MM-dd 23:59:59
	 * 
	 * @return
	 */
	public static String getToDayEndTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		return sdf.format(new Date());
	}

	/**
	 * 获取获取当天开始时间的str， yyyy-MM-dd 00:00:00
	 * 
	 * @return
	 */
	public static String getToDayStartTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		return sdf.format(new Date());
	}

	/**
	 * 获取期号，以日期格士
	 * 
	 * @return
	 */
	public static String getDateCycle() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取当月月初开始时间
	 * 
	 * @return
	 */
	public static String getMonthBeginDate() {
		Calendar cale = Calendar.getInstance();
		// 获取当月第一天
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		String firstDay = format.format(cale.getTime());

		return firstDay;
	}

	/**
	 * 获取当月月末结束时间
	 * 
	 * @return
	 */
	public static String getMonthEndDate() {
		Calendar cale = Calendar.getInstance();
		// 获取当月最后一天
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
		String endDay = format.format(cale.getTime());

		return endDay;
	}

	/**
	 * 获取时间，格式2017-12-19，参数代表相对今天隔了几天，如-1表示昨天，1表示明天
	 * 
	 * @param time
	 * @return
	 */
	public static String getDateNoTime(int time) {
		Date dt = new Date();
		String resultTime = "";
		Calendar start = Calendar.getInstance();
		start.setTime(dt);
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);
		start.set(Calendar.MILLISECOND, 0);
		start.add(Calendar.DAY_OF_MONTH, time);
		resultTime = new SimpleDateFormat("yyyy-MM-dd").format(start.getTime());
		return resultTime;
	}

	public static String getDateCycle2() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	// 计算给开始日期 结束日期 的间隔天数 yyyy-MM-dd

	public static int getDayLength(String start_date, String end_date) throws Exception {

		Date fromDate = getStrToDate(start_date, "yyyy-MM-dd"); // 开始日期
		Date toDate = getStrToDate(end_date, "yyyy-MM-dd"); // 结束日期
		long from = fromDate.getTime();
		long to = toDate.getTime();
		// 一天等于多少毫秒：24*3600*1000
		int day = (int) ((to - from) / (24 * 60 * 60 * 1000));
		return day;
	}

	public static Date getStrToDate(String date, String fomtter) throws Exception {
		DateFormat df = new SimpleDateFormat(fomtter);
		return df.parse(date);
	}

	/**
	 * 判断对象所有属性是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean checkObjFieldIsNotNull(Object obj) {
		try {
			for (Field f : obj.getClass().getDeclaredFields()) {
				f.setAccessible(true);
				if (f.get(obj) != null) {
					return true;
				}
			}
		} catch (IllegalAccessException e) {

		}
		return false;
	}

	/**
	 * 获取当前月的所有天，格式：2018-02-06
	 * 
	 * @return
	 */
	public static List<String> getDayList() {
		List<String> list = new ArrayList<String>();
		Calendar cale = Calendar.getInstance();
		// 获取当月第一天
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		int size = cale.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 0; i < size; i++) {
			cale.set(Calendar.DAY_OF_MONTH, i + 1);
			String str = format.format(cale.getTime());
			//System.out.println(str);
			list.add(str);
		}
		return list;
	}
	
	/**
	 * 获取订单开头,返回type+用户ID补足9位数
	 * @param order
	 * @return
	 */
	public static String getOrderStartStr(String type, Integer userId) {
		String result = type + String.format("%0" + 9 + "d", userId);
		return result;
	}
	
	/**
	 * 生成非重复订单号，理论上限1毫秒1000个，可扩展
	 * @param tname 测试用
	 */
	public static String makeOrderNum(String type, Integer userId) {
		// 最终生成的订单号
		String finOrderNum = "";
		try {
			synchronized (lockObj) {
				// 取系统当前时间作为订单号变量前半部分，精确到毫秒
				long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
				// 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万
				if (orderNumCount >= maxPerMSECSize) {
					orderNumCount = 0L;
				}
				// 组装订单号
				String countStr = maxPerMSECSize + orderNumCount + "";
				finOrderNum = nowLong + countStr.substring(1);
				orderNumCount++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finOrderNum = getOrderStartStr(type, userId) + finOrderNum;
		return finOrderNum;
	}
	/**
	 * 获取当前年份
	 * 
	 * @return
	 */
	public static String getCurrentYear() {
		Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
	}
	
	/**
	 * 获取当前年月
	 * 
	 * @return
	 */
	public static String getCurrentYearMonth() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	/**
	 * 获取当前月
	 * 
	 * @return
	 */
	public static String getCurrentMonth() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
}
