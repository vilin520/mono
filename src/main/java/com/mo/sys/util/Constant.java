package com.mo.sys.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Constant {
	public static final String STATUS = "status";
	public static final String STATUS_OK = "ok";
	public static final String DATA = "data";
	public static final String STATUS_ERROR = "error";
	public static final String INFO = "info";
	public static String BASE_HOST = "http://gajqz.chengdu.gov.cn/quanzhi";// 域名或者IP

	/**
	 * 图片命名规则
	 * 
	 * @author raochy
	 * @date 创建时间：2017年9月8日 下午7:16:45
	 * @version
	 * @parameter
	 * @since
	 * @return
	 */
	public static String getImageAddress() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String address = df.format(new Date());
		String imageAddress = UUID.randomUUID().toString().substring(3, 21)
				+ address + new Random().nextInt(100);
		return imageAddress;
	}

	/**
	 * 犬证命名规则，根据dogId生成
	 * 
	 * @author raochy
	 * @date 创建时间：2017年9月8日 下午7:17:10
	 * @version
	 * @parameter
	 * @since
	 * @return
	 */
	public static String getRegistrationNum(int dogId) {
		String code = dogId + "";
		int leng = (code.trim()).length(); // 定义长度
		switch (leng) {
		case 1:
			code = "00000" + code;
			break;
		case 2:
			code = "0000" + code;
			break;
		case 3:
			code = "000" + code;
			break;
		case 4:
			code = "00" + code;
			break;
		case 5:
			code = "0" + code;
			break;
		}
		return code;
	}

	public static String getBASE_HOST() {
		return BASE_HOST;
	}

	public static void setBASE_HOST(String bASE_HOST) {
		BASE_HOST = bASE_HOST;
	}
	
}
