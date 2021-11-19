//package com.example.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.example.service.testcaseService;
//import com.example.service.testsuiteService;
//import com.example.vo.testcase;
//import com.example.vo.testsuite;
//import com.example.vo.users;
//
//@Controller
//@RequestMapping(value = "/testcase")
//public class testcaseController {
//	
//	@Autowired
//	testcaseService testcaseser;
//	@Autowired
//	testsuiteService testsuiteser;
//
//	@GetMapping("/")
//    public String list() {
//		System.out.println("---------------starting testcase---------------------");
//    	return "Test";
//    }
//	
//	@RequestMapping(value="/{id}")
//    public String list(Model model,@PathVariable("id") Integer id) {
//		System.out.println(id);
//		
//		List<testsuite> suiteData = testsuiteser.findsuite(id);
//		model.addAttribute("suiteData", suiteData);
//		List<testcase> caseData = testcaseser.findcase(id);
//		model.addAttribute("caseData", caseData);
//		
////		List<users> Data = userser.getusers();
////		model.addAttribute("Data",Data);
////		List<testsuite> Datasuite = testsuiteser.getusersuite();
////		model.addAttribute("Datasuite",Datasuite);
//		Date dt = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		String rn = sdf.format(dt);
//		model.addAttribute("rightnow",rn);
//		
//    	return "Testcase";
//    }
//	
//	@ResponseBody
//	@PostMapping("/querycase")
//	public String querytestcase(@RequestBody Map<String,Object> params) {
//		boolean result=true;
//		
//		int testsuiteid = Integer.parseInt(params.get("testsuiteid").toString());
//		String name = params.get("name").toString();
//		
//		
//		result = testcaseser.querycase(testsuiteid,name);
//		
//		if(result) {
//			return "Success";
//		}else {
//			return "Error";
//		}
//	}
//	
//	@ResponseBody
//	@PostMapping("/createcase")
//	public String createtestcase(@RequestBody Map<String,Object> params) {
//		boolean result=true;
//		
//		int testsuiteid = (Integer)params.get("testsuiteid");
//		String name = params.get("name").toString();
//		String description = params.get("description").toString();
//		
//		result = testcaseser.createcase(testsuiteid, name, description);
//		
//		return result?"Success":"Error";
//	}
//}
