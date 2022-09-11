package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.Loginbean;
import com.Bean.Signupbean;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate stmt;

	public void signupuser(Signupbean signup) {
		System.out.println(signup.getFirstName());
		stmt.update("insert into users(firstname,lastname,gender,email,password,usertype)values(?,?,?,?,?,?)",
				signup.getFirstName(), signup.getLastName(), signup.getGender(), signup.getEmail(),
				signup.getPassword(), signup.getUsertype());
	}

	public List<Signupbean> ListAlluser() {
		List<Signupbean> list = stmt.query("select * from users",
				new BeanPropertyRowMapper<Signupbean>(Signupbean.class));
		return list;
	}

	public void deleteuser(int userid) {
		stmt.update("delete from users where userid=?", userid);
	}

	public Signupbean authenticate(Loginbean login) {

		Signupbean sign = null;
		try {
			sign = stmt.queryForObject("select * from users where email = ? and password = ?",
					new BeanPropertyRowMapper<Signupbean>(Signupbean.class),
					new Object[] { login.getEmail(), login.getPassword() });
			System.out.println(sign);
		} catch (Exception e) {
			System.out.println("invalid email and password");
		}
		return sign;

	}
	
     public Signupbean getUserByUserId(int userId) {
		Signupbean oneuserlist = stmt.queryForObject("select * from users where userId = ?", new BeanPropertyRowMapper<Signupbean>(Signupbean.class),new Object[] {userId});
		return oneuserlist;
	}
     
     public void updateUser(Signupbean user) {
    	 System.out.println(user.getFirstName());
    	 System.out.println(user.getUserid());
 		stmt.update("update users set firstname = ? , lastname = ? where userid = ? ", user.getFirstName(),
 				user.getLastName(), user.getUserid());
 	}

}
