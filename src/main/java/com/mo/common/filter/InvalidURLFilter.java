package com.mo.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mo.common.util.SysConst;

// 后台路径拦截器
public class InvalidURLFilter implements Filter {
	
	private Logger logger = Logger.getLogger(InvalidURLFilter.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res  =(HttpServletResponse) response;
//        String[] noFilters = new String[] { "/user/login","/handwork","/admin" };
//        String contextPath = req.getContextPath();
//        String uri = req.getRequestURI();
//        boolean dofilter = true;
//        for(String noFilter: noFilters){
//            if(uri.indexOf(noFilter) != -1){
//               dofilter = false; 
//            }
//        }
//        if(dofilter){
//            if(req.getSession().getAttribute(SysConst.CURRENT_USER) == null) {
//                res.sendRedirect(contextPath + "/user/login.action");
//                return;
//            }
//        }
//        logger.info(uri);
//        chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
