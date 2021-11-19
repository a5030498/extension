/*package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.eventService;

@Controller
@RequestMapping(value = "/event")
public class eventController {
	
	@Autowired
	eventService eventser;

	@GetMapping("/")
    public String list() {
		System.out.println("---------------starting event---------------------");
    	return "Test";
    }
	
	@ResponseBody
	@PostMapping("/queryevent")
	public String queryevent(@RequestBody Map<String,Object> params) {
		boolean result=true;
		
		int testcaseid = Integer.parseInt(params.get("testcaseid").toString());
		
		result = eventser.queryevent(testcaseid);
		
		if(result) {
			return "Success";
		}else {
			return "Error";
		}
	}
	
	@ResponseBody
	@PostMapping("/createevent")
	public String createevent(@RequestBody Map<String,Object> params) throws ParseException {
		boolean result=true;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		int testcaseid = (Integer)params.get("testcaseid");
		Date starttime = sdf.parse(params.get("starttime").toString());
		
		result = eventser.createevent(testcaseid, starttime);
		
		if(result) {
			return "Success";
		}else {
			return "Error";
		}
	}
}*/
