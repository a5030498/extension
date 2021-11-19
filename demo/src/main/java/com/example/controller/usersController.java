//package com.example.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
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
//import com.example.service.testcaseService;
//import com.example.service.testsuiteService;
//import com.example.service.usersService;
//import com.example.vo.testsuite;
//import com.example.vo.users;
//
//@Controller
//@RequestMapping(value = "/testsuite")
//public class usersController {
//	
//	@Autowired
//	usersService userser;
//	@Autowired
//	testsuiteService testsuiteser;
//	@Autowired
//	testcaseService testcaseser;
//
//	@GetMapping("")
//    public String list(Model model) {
//		System.out.println("---------------start Users---------------------");
//		
//		List<users> Data = userser.getusers();
//		model.addAttribute("Data",Data);
//		List<testsuite> Datasuite = testsuiteser.getusersuite();
//		model.addAttribute("Datasuite",Datasuite);
//		Date dt = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		String rn = sdf.format(dt);
//		model.addAttribute("rightnow",rn);
//		
//		ArrayList<Integer> allcount = new ArrayList<Integer>();
//		ArrayList<Integer> errorcount = new ArrayList<Integer>();
//		ArrayList<Integer> gifid = testsuiteser.getallid(2);
//		ArrayList<String> gifName = testsuiteser.getallname(2);
//		ArrayList<String> Name = new ArrayList<String>();
//		//allcount
//		for(Integer id:gifid) {
//			int count = testcaseser.getallcount(id);
//			allcount.add(count);
//		}
//		//errorcount
//		for(Integer id:gifid) {
//			int ecount = testcaseser.geterrorcount(id);
//			errorcount.add(ecount);
//		}
//		
//		for(int i=0;i<gifName.size();i++) {
//			Name.add("\"" + gifName.get(i) + "\"");
//		}
//		model.addAttribute("count", allcount);
//		model.addAttribute("errorcount", errorcount);
//		model.addAttribute("namedata", Name);
//		
//    	return "Testsuite";
//    }
//	
//	@ResponseBody
//	@PostMapping("/queryuser")
//	public String queryuser(@RequestBody Map<String,Object> params) {
//		boolean result=true;
//		
//		String name = params.get("name").toString();
//		String email = params.get("email").toString();
//		String pwd = params.get("pwd").toString();
//		
//		result = userser.queryuser(name, email, pwd);
//		
//		if(result) {
//			return "Success";
//		}else {
//			return "Error";
//		}
//	}
//	
//	@ResponseBody
//	@PostMapping("/createuser")
//	public String createuser(@RequestBody Map<String,Object> params) {
//		boolean result=true;
//		
//		String name = params.get("name").toString();
//		String email = params.get("email").toString();
//		String pwd = params.get("pwd").toString();
//		
//		result = userser.createuser(name, email, pwd);
//		
//		if(result) {
//			return "Success";
//		}else {
//			return "Error";
//		}
//	}
//}
