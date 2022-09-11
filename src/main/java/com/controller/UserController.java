package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bean.Signupbean;
import com.Dao.UserDao;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;
	
	@GetMapping("/Listusers")
	
	public String ListAlluser(Model model) {
		List<Signupbean> users =  userDao.ListAlluser();
		model.addAttribute("user",users);
		return "ListUsers";
		
	}
	@GetMapping("/deletuser")
	public String deleteuse(@RequestParam("userid") int userid,Model model) {
		userDao.deleteuser(userid);
		return "redirect:/Listusers";

	}
	
	@GetMapping("/viewuser")
	public String viewUser(@RequestParam("userId") int userid,Model model) {
		Signupbean user =userDao.getUserByUserId(userid);
		model.addAttribute("users",user);
		return "viewuser";
	}
	
	@GetMapping("/edituser") 
	public String editUser(@RequestParam("userId") int userId,Model model) {
		Signupbean user =userDao.getUserByUserId(userId);
		model.addAttribute("user",user);
		return "EditUser";
	}
	
	@PostMapping("/updateuser")
	public String updateuser(Signupbean user) {
		userDao.updateUser(user);
		return "redirect:/Listusers";
	}
	
	
	

}
