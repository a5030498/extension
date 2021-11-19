//package com.example.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.example.dao.eventRepository;
//import com.example.vo.event;
//
//@Service
//public class eventService {
//
//	@Autowired
//	eventRepository eventrepo;
//	
//	public boolean queryevent(int testcaseid) {
//		boolean result = true;
//		List<event> Levent = new ArrayList<>();
//		
//		
//		Levent = eventrepo.findByTestcaseid(testcaseid);
//		
//		if(Levent.size()==0||Levent == null) {
//			result = false;
//		}
//		
//		return result;
//	}
//	
//	public boolean createevent(int testcaseid,Date starttime) {
//		boolean result;
//		event Levent = new event();
//		
//		try {
//			Levent.setTestcaseid(testcaseid);
//			Levent.setStatus("e");
//			Levent.setStarttime(starttime);
//			
//			Date dt = new Date();
//			Levent.setCreatedate(dt);
//			Levent.setDuration(000);
//			
//			eventrepo.save(Levent);
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
//}
