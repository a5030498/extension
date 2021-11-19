//package com.example.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.example.dao.testsuiteRepository;
//import com.example.vo.testsuite;
//
//@Service
//public class testsuiteService {
//
//	@Autowired
//	testsuiteRepository testsuiterepo;
//	
//	public boolean querysuite(int userid,String name) {
//		boolean result = true;
//		List<testsuite> suite = new ArrayList<>();
//		
//		if(name ==null)name = "";
//		name = "%" + name + "%";
//		
//		suite = testsuiterepo.findByUsersidAndNameLike(userid,name);
//		
//		if(suite.size()==0||suite == null) {
//			result = false;
//		}
//		
//		return result;
//	}
//	
//	public boolean createsuite(int userid,String name,String description) {
//		boolean result;
//		testsuite suite = new testsuite();
//		
//		try {
//			if(name == null)name = "";
//			if(description == null)description = "";
//			
//			suite.setUsersid(userid);
//			suite.setName(name);
//			suite.setDescription(description);
//			
//			Date dt = new Date();
//			suite.setCreatedate(dt);
//			
//			testsuiterepo.save(suite);
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
//	
//	public List<testsuite> getusersuite() {
//		int userid = 2;
//		List<testsuite> suite = testsuiterepo.findByUsersid(userid);
//		
//		return suite;
//	}
//	
//	public List<testsuite> findsuite(Integer id){
//		List<testsuite> suite = testsuiterepo.findById(id);
//		return suite;
//	}
//	
//	public ArrayList<Integer> getallid(int id){
//		String nid = String.valueOf(id);
//		List<testsuite> suite = testsuiterepo.findDistinctByUsersid(nid);
//		ArrayList<Integer> allcount = new ArrayList<>();
//		for(int i=0;i<suite.size();i++) {
//			allcount.add(suite.get(i).getId());
//		}
//		
//		return allcount;
//	}
//	
//	public ArrayList<String> getallname(int id){
//		String nid = String.valueOf(id);
//		List<testsuite> suite = testsuiterepo.findDistinctByUsersid(nid);
//		ArrayList<String> allcount = new ArrayList<>();
//		for(int i=0;i<suite.size();i++) {
//			allcount.add(suite.get(i).getName());
//		}
//		
//		return allcount;
//	}
//}
