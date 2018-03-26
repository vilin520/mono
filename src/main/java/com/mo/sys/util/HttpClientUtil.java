package com.mo.sys.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * HttpClient工具类
 * 
 * @author so123
 * 
 */
@SuppressWarnings("deprecation")
public class HttpClientUtil {
	/**
	 * 
	 * @author raochy
	 * @date 创建时间：2017年8月24日 下午6:03:22
	 * @version
	 * @parameter url：地址 paras:参数列表，map形式
	 * @since
	 * @return json字符串
	 */
	@SuppressWarnings("resource")
	public static String resultByGet(String url, Map<String, String> paras) {
		// 读取响应内容
		String result = "";
		// get方法设置参数要？号
		StringBuilder sb = new StringBuilder(url);
		sb.append("?");
		Iterator<Map.Entry<String, String>> it = paras.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			try {
				sb.append(entry.getKey() + "=").append(URLEncoder.encode(entry.getValue(), "utf-8")).append("&&");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 1.得到浏览器
		HttpClient httpClient = new DefaultHttpClient();// 浏览器
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000); 
		// 2指定请求方式
		HttpGet httpGet = new HttpGet(sb.toString());
		// 3.执行请求
		HttpResponse httpResponse;
		try {
			httpResponse = httpClient.execute(httpGet);
			// 4 判断请求是否成功
			int status = httpResponse.getStatusLine().getStatusCode();
			if (status == 200) {
				result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * @author raochy
	 * @date 创建时间：2017年9月7日 下午4:29:14
	 * @version
	 * @parameter 参数拼接到地址栏
	 * @since
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String resultByGet(String url) {
		// 读取响应内容
		String result = "";
		// 1.得到浏览器
		HttpClient httpClient = new DefaultHttpClient();// 浏览器
		// 2指定请求方式
		HttpGet httpGet = new HttpGet(url);
		// 3.执行请求
		HttpResponse httpResponse;
		try {
			httpResponse = httpClient.execute(httpGet);
			// 4 判断请求是否成功
			int status = httpResponse.getStatusLine().getStatusCode();
			if (status == 200) {
				result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * @author raochy
	 * @date 创建时间：2017年9月7日 下午4:30:17
	 * @version
	 * @parameter 地址和json格式的数据
	 * @since
	 * @return json格式的字符串
	 */
	@SuppressWarnings("resource")
	public static String resultByPost(String url, String json) throws UnsupportedEncodingException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String resultStr = "";
		HttpPost method = new HttpPost(url);
		StringEntity entity;
		try {
			// 解决中文乱码问题
			entity = new StringEntity(json, "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			method.setEntity(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpResponse result;
		try {
			result = httpClient.execute(method);
			resultStr = EntityUtils.toString(result.getEntity());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 请求结束，返回结果
		return resultStr;
	}

	@SuppressWarnings("resource")
	public static String resultByPost(String url, Map<String, String> paras) {
		String result = "";
		// POST的URL
		HttpPost httppost = new HttpPost(url);
		// 建立HttpPost对象
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 建立一个NameValuePair数组，用于存储欲传送的参数

		Iterator<Map.Entry<String, String>> it = paras.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			try {
				params.add(new BasicNameValuePair(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 添加参数
		try {
			httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 设置编码
		HttpResponse response;
		try {
			response = new DefaultHttpClient().execute(httppost);
			// 发送Post,并返回一个HttpResponse对象
			if (response.getStatusLine().getStatusCode() == 200) {// 如果状态码为200,就是正常返回
				result = EntityUtils.toString(response.getEntity());
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
