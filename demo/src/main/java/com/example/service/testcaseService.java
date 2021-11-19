//package com.example.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.example.dao.testcaseRepository;
//import com.example.dao.testsuiteRepository;
//import com.example.dao.usersRepository;
//import com.example.vo.testcase;
//
//@Service
//public class testcaseService {
//
//	@Autowired
//	testcaseRepository testcaserepo;
//	
//	public boolean querycase(int testsuiteid,String name) {
//		boolean result = true;
//		List<testcase> tcase = new ArrayList<>();
//		
//		if(name == null)name = "";
//		name = "%" + name + "%";
//		
//		tcase = testcaserepo.findByTestsuiteidAndNameLike(testsuiteid,name);
//		
//		if(tcase.size()==0||tcase == null) {
//			result = false;
//		}
//		
//		return result;
//	}
//	
//	public boolean createcase(int testsuiteid,String name,String description) {
//		boolean result;
//		testcase tcase = new testcase();
//		
//		try {
//			if(name == null)name = "";
//			if(description == null)description = "";
//			
//			tcase.setTestsuiteid(testsuiteid);
//			tcase.setName(name);
//			tcase.setDescription(description);
//			
//			Date dt = new Date();
//			tcase.setCreatedate(dt);
//			
//			testcaserepo.save(tcase);
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
//	public List<testcase> findcase(int id){
//		List<testcase> casedata = testcaserepo.findByTestsuiteid(id);
//		return casedata;
//	}
//	
//	public int getallcount(Integer id) {
//		int suite = testcaserepo.countByTestsuiteid(id);
//		return suite;
//	}
//	
//	public int geterrorcount(Integer id) {
//		int suite = testcaserepo.countByTestsuiteidAndEnabled(id,"f");
//		return suite;
//	}
//}
