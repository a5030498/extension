//package com.example.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.example.dao.stepRepository;
//import com.example.vo.step;
//
//@Service
//public class stepService {
//
//	@Autowired
//	stepRepository steprepo;
//	
//	public boolean querystep(int eventid,int httpstatus,int step,String requestmethod,String requesturl) {
//		boolean result = true;
//		List<step> Lstep = new ArrayList<>();
//		
//		requestmethod = requestmethod==null?"":requestmethod;
//		requestmethod = "%" + requestmethod + "%";
//		requesturl = requesturl==null?"":requesturl;
//		requesturl = "%" + requesturl + "%";
//		
//		Lstep = steprepo.
//				findByEventidAndRequestmethodLikeAndRequesturlLikeAndHttpstatusAndStep(eventid,requestmethod,requesturl,httpstatus,step);
//		
//		if(Lstep.size()==0||Lstep == null) {
//			result = false;
//		}
//		
//		return result;
//	}
//	
//	public boolean createstep(int eventid,int httpstatus,int step,String requestmethod,String requesturl,Date starttime) {
//		boolean result;
//		step Lstep = new step();
//		
//		try {
//			requestmethod = requestmethod==null?"":requestmethod;
//			requesturl = requesturl==null?"":requesturl;
//			
//			Lstep.setEventid(eventid);
//			Lstep.setHttpstatus(httpstatus);
//			Lstep.setStep(step);
//			Lstep.setRequestmethod(requestmethod);
//			Lstep.setRequesturl(requesturl);
//			Lstep.setStarttime(starttime);
//			Lstep.setDuration(000);
//			
//			steprepo.save(Lstep);
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
