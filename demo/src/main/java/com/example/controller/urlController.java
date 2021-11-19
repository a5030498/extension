//package com.example.controller;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.example.service.eventService;
//import com.example.service.stepService;
//import com.example.service.testcaseService;
//import com.example.service.urlService;
//import com.example.vo.users;
//
//@Controller
//@RequestMapping(value = "/url")
//public class urlController {
//	
//	@Autowired
//	urlService urlser;
//
//	@GetMapping("/")
//    public String list() {
//		System.out.println("---------------starting url---------------------");
//    	return "Test";
//    }
//	
//	@ResponseBody
//	@PostMapping("/queryurl")
//	public String queryurl(@RequestBody Map<String,Object> params) {
//		boolean result=true;
//		
//		int stepid = Integer.parseInt(params.get("stepid").toString());
//		String address = params.get("address").toString();
//		int size = (Integer)params.get("size");
//		
//		result = urlser.queryurl(stepid,size,address);
//		
//		if(result) {
//			return "Success";
//		}else {
//			return "Error";
//		}
//	}
//	
//	@ResponseBody
//	@PostMapping("/createstep")
//	public String createurl(@RequestBody Map<String,Object> params) throws ParseException {
//		boolean result=true;
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		
//		int stepid = (Integer)params.get("stepid");
//		int size = (Integer)params.get("size");
//		String address = params.get("address").toString();
//		Date starttime = sdf.parse(params.get("starttime").toString());
//		Date endtime = sdf.parse(params.get("endtime").toString());
//		
//		result = urlser.createurl(stepid,size,address,starttime,endtime);
//		
//		if(result) {
//			return "Success";
//		}else {
//			return "Error";
//		}
//	}
//}
