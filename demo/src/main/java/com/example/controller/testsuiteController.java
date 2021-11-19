//package com.example.controller;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.example.service.testsuiteService;
//
//@Controller
//@RequestMapping(value = "/testsuite")
//public class testsuiteController {
//	
//	@Autowired
//	testsuiteService testsuiteser;
//
//	@GetMapping("/")
//    public String list(Model model) {
//		System.out.println("---------------starting testsuite---------------------");
//    	return "Test";
//    }
//	
//	@ResponseBody
//	@PostMapping("/querysuite")
//	public String querytestsuite(@RequestBody Map<String,Object> params) {
//		boolean result=true;
//		
//		int userid = Integer.parseInt(params.get("userid").toString());
//		String name = params.get("name").toString();
//		
//		result = testsuiteser.querysuite(userid,name);
//		
//		if(result) {
//			return "Success";
//		}else {
//			return "Error";
//		}
//	}
//	
//	@ResponseBody
//	@PostMapping("/createtestsuite")
//	public String createtestsuite(@RequestBody Map<String,Object> params) {
//		boolean result=true;
//		
//		int userid = Integer.parseInt(params.get("userid").toString());
//		String name = params.get("name").toString();
//		String description = params.get("description").toString();
//		
//		result = testsuiteser.createsuite(userid, name, description);
//		
//		if(result) {
//			return "Success";
//		}else {
//			return "Error";
//		}
//	}
//}
