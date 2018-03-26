package com.mo.sys.util;

/**
 * 一些常量
 */

public class SysConst {

	//图片存放本地地址  
//	public static final String SAVE_IMG_PATH = "d:/MyUpLoadImgs";//本地测试
	public static final String SAVE_IMG_PATH = "/anmoyi/upload/img";//测试

	//图片访问地址  
	public static final String ASK_ACT_PATH = "/actImg/"; 
	public static final String ASK_QRCODE_PATH = "/qrcode/";
	public static final String ASK_ADV_PATH = "/advImg/";

	//按摩椅设备编号加解密KEY
	public static final String CODE_KEY = "hSjedFg6789GXY";
	
	/****** 一些常量 ********/
	//排序方式
	public enum SortBy{
		ASC,DESC;
	}
	//ajax返回状态
	public static final String STATUS = "status";
	public static final String STATUS_SUCCESS = "ok";
	public static final String STATUS_FAILED = "failed";
	public static final String INFO = "info";
	public static final String INFO_SUCCESS = "操作成功";
	public static final String INFO_FAILED = "操作失败";
	public static final String INFO_PWD_FAILED = "密码错误";
	public static final String INFO_PWD_NOTSAME = "两次输入不一致";
	public static final String INFO_PWD_NOCHANGE = "新密码不能与旧密码相同";
	public static final String INFO_PWD_NEEDLOGIN = "权限校验失败，请先登录";
	
	/****** 组装扫码二维码微信访问的地址 ********/
	
	public static final String APPID = "wxb0a444bbde14d6e7";
	public static final String SCOPE = "snsapi_base";// 应用授权作用域，snsapi_userinfo需要授权
	//二维码的内容前缀
	public static final String RedirectUrl = "http://moxingxia.jijiankj.com/anmoyi/home/redirectwx?equNum=";
	
}
