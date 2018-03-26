package com.mo.sys.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.mo.common.util.AesException;
import com.mo.common.util.WXBizMsgCrypt;

import com.mo.sys.service.UserService;



/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/EnterpriseWeChat")
public class EnterpriseWeChatController {
	
	@Autowired
	private UserService userService;
	
	
	
	/**
	 * @param response
	 * @return 
	 * @see 进入首页
	 */
	@RequestMapping(value="GoToIndex.do")	
	public String SystemReceiveURL(HttpServletResponse response){
		
		
		return "/dist/example/index";
	}
	
	
	
	@RequestMapping(value="SystemEventReception.do",method=RequestMethod.GET)
	public String SystemEventReception(HttpServletRequest request,HttpServletResponse response) throws AesException, IOException{
		//http://www.monovi.cn/mono/EnterpriseWeChat/SystemEventReception.do
		String sToken = "SbnbQjKO";
		String sCorpID = "wwcd978c40450dbb8d";
		String sEncodingAESKey = "AcgsbCWCWHJ2F1chiJ2Y7Wc2n3UoGAjXWavrLgsyBWH";		
		
		String sVerifyMsgSig = request.getParameter("msg_signature");
		String sVerifyTimeStamp = request.getParameter("timestamp");
		String sVerifyNonce = request.getParameter("nonce");
		String sVerifyEchoStr = request.getParameter("echostr");
		
		WXBizMsgCrypt wxcpt;
		String sEchoStr; //需要返回的明文
		PrintWriter out = response.getWriter();
		try {
			wxcpt = new WXBizMsgCrypt(sToken,sEncodingAESKey,sCorpID);	
			sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp,
					sVerifyNonce, sVerifyEchoStr);
			System.out.println("verifyurl echostr: " + sEchoStr);
			// 验证URL成功，将sEchoStr返回		
			out.print(sEchoStr);
			out.close();
			
		} catch (Exception e) {
			//验证URL失败，错误原因请查看异常
			e.printStackTrace();
		}
			
		return "/EnterpriseWeChat/hello";
	}
	
	@RequestMapping(value="EnterpriseWeChatindex.do")
	public String EnterpriseWeChatindex(HttpServletResponse response,Model model){
		
				
		return "/X-admin/index";
	}
}
