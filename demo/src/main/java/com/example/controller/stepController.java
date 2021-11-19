//package com.example.controller;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
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
//import com.example.service.stepService;
//
//@Controller
//@RequestMapping(value = "/step")
//public class stepController {
//	
//	@Autowired
//	stepService stepser;
//
//	@GetMapping("/")
//    public String list() {
//		System.out.println("---------------starting step---------------------");
//    	return "Test";
//    }
//	
//	@ResponseBody
//	@PostMapping("/querystep")
//	public String querystep(@RequestBody Map<String,Object> params) throws ParseException  {
//		boolean result=true;
//		
//		int eventid = Integer.parseInt(params.get("eventid").toString());
//		int httpstatus = (Integer)params.get("httpstatus");
//		int step = (Integer)params.get("step");
//		String requestmethod = params.get("requestmethod").toString();
//		String requesturl = params.get("requesturl").toString();
//		
//		result = stepser.querystep(eventid,httpstatus,step,requestmethod,requesturl);
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
//	public String createstep(@RequestBody Map<String,Object> params) throws ParseException {
//		boolean result=true;
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		
//		int eventid = (Integer)params.get("eventid");
//		int httpstatus = (Integer)params.get("httpstatus");
//		int step = (Integer)params.get("step");
//		String requestmethod = params.get("requestmethod").toString();
//		String requesturl = params.get("requesturl").toString();
//		Date starttime = sdf.parse(params.get("starttime").toString());
//		
//		result = stepser.createstep(eventid,httpstatus,step,requestmethod,requesturl,starttime);
//		
//		if(result) {
//			return "Success";
//		}else {
//			return "Error";
//		}
//	}
//}
