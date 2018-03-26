package com.mo.sys.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class MyConfig extends WXPayConfig {

	private byte[] certData;
		
	// 公众号配置
	private static final String APPID = "wxb0a444bbde14d6e7";// 公众号APPID(摩行侠会)
		
	// 商户号配置
	private static final String MCHID = "1495057712";// 商户号(新商户账号)
	private static final String MCH_SECRET = "f23d57fd5e3d4d2891cf280f752656e6";// 商户平台支付的秘钥(新商户账号)
	

	public MyConfig() throws Exception {

		InputStream inStream = MyConfig.class.getClassLoader().getResourceAsStream("apiclient_cert.p12");
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100]; // buff用于存放循环读取的临时数据
		int rc = 0;
		while ((rc = inStream.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		this.certData = swapStream.toByteArray(); // in_b为转换之后的结果

		inStream.close();
		swapStream.close();
		/*
		 * String certPath = "/apiclient_cert.p12"; File file = new
		 * File(certPath); InputStream certStream = new FileInputStream(file);
		 * this.certData = new byte[(int) file.length()];
		 * certStream.read(this.certData); certStream.close();
		 */
	}

	@Override
	public String getAppID() {
		return APPID;
	}

	@Override
	public String getMchID() {
		return MCHID;
	}

	public String getKey() {
		return MCH_SECRET;
	}

	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	public int getHttpConnectTimeoutMs() {
		return 5000;
	}

	public int getHttpReadTimeoutMs() {
		return 8000;
	}

	@Override
	IWXPayDomain getWXPayDomain() {
		return WXPayDomainSimpleImpl.instance();
	}

}