package com.msaone.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.msaone.user.model.UserVO;
import com.msaone.user.service.User2Service;


@RestController
public class UserController {
	
	@Autowired
	public User2Service userService;
	
	@RequestMapping("/form") //홈페이지용
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/userform");
		
		return mav;
	}
	
	@RequestMapping("/api/getform") 
	@ResponseBody
	public UserVO getform(@RequestBody UserVO uv) {
		UserVO uv2 = new UserVO();
		uv2 = userService.getUser(uv.id);
		
		return uv2;
	}
	
	
	@RequestMapping("/api/signup") //api 붙은 것들은 기능
	public void signup(@RequestBody UserVO uv) {
		System.out.println("user name ===> "+uv.name);
		System.out.println("user id ===> "+uv.id);
		userService.saveUser(uv.id, uv.name);
	}
	
	@RequestMapping("/userlist")
	public ModelAndView userlist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/userlist");
		
		return mav;
	}

	@RequestMapping("/api/list")
	@ResponseBody
	public List<UserVO> list(){
		List<UserVO> list = userService.getUserList();
		
		return list;
		
	}
	
	@RequestMapping("/api/update") 
	@ResponseBody
	public void update(@RequestBody UserVO uv) {
		userService.updateUser(uv.id, uv.name);
	}
	
	@RequestMapping("/api/delete") 
	@ResponseBody
	public void delete(@RequestBody UserVO uv) {
		userService.deleteUser(uv.id);
	}
	

	
	@RequestMapping("/save") //save 연습
	public ModelAndView save() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/usersave");
		
		return mav;
	}
}