package com.mo.sys.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mo.sys.model.User;
import com.mo.sys.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 展示用户
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public String list(Model model) {
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "/user/list";
	}
	
	/**
	 * 跳转到添加用户页面
	 * @param model
	 * @param loginName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "toAdd.do")
	public String toAdd(Model model) {
		return "/user/add";
	}
	
	/**
	 * 添加用户,完成后跳转到list
	 * @param model
	 * @param loginName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String list(Model model, String loginName,String password) {
		User user = new User();
		user.setLoginName(loginName);
		user.setPassword(password);
		userService.create(user);
		if(userService!=null){
			throw new RuntimeException("测试一下");
		}
		return "redirect:list.do";
	}

}
