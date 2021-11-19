//package com.example.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.example.dao.usersRepository;
//import com.example.vo.users;
//
//@Service
//public class usersService {
//
//	@Autowired
//	public usersRepository usersrepo;
//	
//	public boolean queryuser(String name,String email,String pwd) {
//		boolean result = true;
//		List<users> user = new ArrayList<>();
//		
//		if(name == null)name = "";
//		name = "%" + name + "%";
//		if(email == null)email = "";
//		email = "%" + email + "%";
//		if(pwd == null)pwd = "";
//		pwd = "%" + pwd + "%";
//		
//		user = usersrepo.findByNameLikeAndEmailLike(name, email);
//		
//		if(user.size()==0||user == null) {
//			result = false;
//		}
//		
//		return result;
//	}
//	
//	public boolean createuser(String name,String email,String pwd) {
//		boolean result;
//		users user = new users();
//		
//		try {
//			if(name == null)name = "";
//			if(email == null)email = "";
//			if(pwd == null)pwd = "";
//			
//			user.setName(name);
//			user.setEmail(email);
//			user.setPassword(pwd);
//			
//			usersrepo.save(user);
//			
//			result = true;
//		
//		}catch(Exception e){
//			System.out.println(e);
//			result = false;
//		}
//		
//		return result;
//	}
//	public List<users> getusers(){
//		String name = "%kazma%";
//		String email = "%kazmali@gmail.com%";
//		
//		List<users> Data = usersrepo.findByNameLikeAndEmailLike(name,email);
//		
//		return Data;
//	}
//}
