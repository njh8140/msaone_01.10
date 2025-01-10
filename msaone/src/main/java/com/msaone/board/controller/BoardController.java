package com.msaone.board.controller;

import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.msaone.board.dao.boardDao;
import com.msaone.board.model.UserVO;
import com.msaone.board.service.UserService;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class BoardController {
//boardDao boarddao = new boardDao(); //이걸 사용해도 가능
	
	@Autowired
	public UserService userService;


	@RequestMapping("/")
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView();
		
		UserVO uv=userService.getUser("1");
		
		System.out.println("----->"+uv.name);
		mav.addObject("name", uv.name);
		mav.addObject("id", uv.id);
		mav.setViewName("main");
		
		return mav;
	}
	
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<UserVO> uvlist = userService.getUserList();
		
		mav.addObject("list" ,uvlist);
		
		mav.setViewName("list");
		
		return mav;
	}
	
	@RequestMapping("/saveform")
	public ModelAndView saveform() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("save");
		
		return mav;
	}
	
	@RequestMapping("/user/save")
	public String save(@RequestParam("id") String id, @RequestParam("name") String name) {
	
		System.out.println("JFJFJJF"+name);
		
		userService.saveUser(id, name);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/user/delete")
	public ModelAndView delete(@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView();
		userService.deleteUser(id);
		ArrayList<UserVO> uvlist = userService.getUserList();
		
		mav.addObject("list", uvlist);
		
		mav.setViewName("deleteList");
		
		return mav;
	}
	
	@RequestMapping("/deleteList")
	public ModelAndView deleteList() {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<UserVO> uvlist = userService.getUserList();
		
		mav.addObject("list", uvlist);
		
		mav.setViewName("deleteList");
		
		return mav;
	}
	
	@RequestMapping("/updateList")
	public ModelAndView updateList() {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<UserVO> uvlist = userService.getUserList();
		
		mav.addObject("list", uvlist);
		
		mav.setViewName("updateList");
		
		return mav;
	}
	
	@RequestMapping("/user/update")
	public ModelAndView update(@RequestParam("id") String id, @RequestParam("name") String name) {
		ModelAndView mav = new ModelAndView();
		userService.updateUser(id, name);
		ArrayList<UserVO> uvlist = userService.getUserList();
		
		mav.addObject("list", uvlist);
		
		mav.setViewName("updateList");
		
		return mav;
	}
	
}