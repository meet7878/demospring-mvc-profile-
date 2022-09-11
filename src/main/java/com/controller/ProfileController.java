package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Bean.ProfileBean;
import com.Bean.Signupbean;
import com.Dao.ProfileDao;

@Controller
public class ProfileController {
	@Autowired
	ProfileDao profileDao;

	@GetMapping("/newprofile")
	public String newProfile() {
		return "NewProfile";
	}
	
	@PostMapping("/saveprofile")
	public String saveProfile(@RequestParam("profile") MultipartFile file,HttpSession session) {
		System.out.println(file.getOriginalFilename()); 
		System.out.println(file.getSize());
		
		Signupbean user =(Signupbean)session.getAttribute("users");
		int userId = user.getUserid();
		
		
		String mainpath = "C:\\Users\\lenovo\\eclipse-workspace\\DemoSpringMvc\\src\\main\\webapp\\resources\\images";
		
		File folder = new File(mainpath,userId+"");
		folder.mkdir();
		try {
			File f = new File(folder,file.getOriginalFilename());
			byte b[] = file.getBytes();//read all bytes from uploded file
			FileOutputStream fos =new FileOutputStream(f);
			fos.write(b);
			fos.close();//save and close
			ProfileBean profilebean = new ProfileBean();
			profilebean.setUserId(userId);
			profilebean.setImgurl("resources/images/"+userId+"/"+file.getOriginalFilename());
			profilebean.setActive(true);
			profileDao.addImg(profilebean);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "NewProfile";  
		
	}
	
	@GetMapping("/listprofileimg")
	
	public String getAllImg(HttpSession session,Model model) {
		Signupbean user =(Signupbean)session.getAttribute("users");
		System.out.println(user.getUserid());
		int userId = user.getUserid();
		List<ProfileBean> profile = profileDao.getAllprofileimg(userId);
		model.addAttribute("profiles",profile);
		System.out.println(profile);
		return "listprofileimg";
	

	}
}
