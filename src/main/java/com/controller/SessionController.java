package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Bean.Loginbean;
import com.Bean.Signupbean;
import com.Dao.UserDao;

@Controller
public class SessionController {
	
	@Autowired
	UserDao userDao;

	@RequestMapping(value="/Signup",method=RequestMethod.GET)
	  public String Signup(Model model ) {
		Signupbean sign = new Signupbean();
		model.addAttribute("user",sign);
		  return "Signup";		  
}
	@RequestMapping(value="/saveuser",method=RequestMethod.POST)
	
	public String saveuser( @ModelAttribute("user") @Valid Signupbean user,BindingResult result,Model model) {
			
		if(result.hasErrors()) {
			model.addAttribute("user",user);
			return "Signup";
		}
		
		else {
			System.out.println("fname"+ user.getFirstName());
			System.out.println("result" +result);
			user.setUsertype("customer");
			userDao.signupuser(user);
			model.addAttribute(user);
			model.addAttribute("msg","signup done");
			return "Login";
			
		}
		
	}
	/*
	 * @RequestMapping(value="/loginuser",method = RequestMethod.POST) public String
	 * loginuser(@Valid Loginbean login,BindingResult result) {
	 * if(result.hasErrors()) { //model.addAttribute("user",login); return "Login";
	 * } else { System.out.println("email"+ login.getEmail());
	 * System.out.println("password"+login.getPassword()); return "Home"; }
	 */
		
	@GetMapping("/Login")
	public String login() {
		return "Login";
	}

	@PostMapping("/Login")
	public String authenticate(Loginbean login,Model model,HttpSession session) {
		
		Signupbean sign = userDao.authenticate(login);
		//System.out.println(sign+"1234567");
		if(sign==null) {
			model.addAttribute("msg","Invalid creditial");
			return "Login";
		}
		else if(sign.getUsertype().contentEquals("customer")){
			session.setAttribute("users", sign);
			return "Home";
		}
		else if(sign.getUsertype().contentEquals("admin")){
			session.setAttribute("users", sign);	
            return "Dashboard";
            
 		}
		else {
			model.addAttribute("msg","please contact admin");
			return "Login";
		}
		
	}
	
	}
	



