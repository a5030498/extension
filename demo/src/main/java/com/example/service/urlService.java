//package com.example.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.example.dao.urlRepository;
//import com.example.vo.url;
//
//@Service
//public class urlService {
//
//	@Autowired
//	urlRepository urlrepo;
//	
//	public boolean queryurl(int stepid,int size,String address) {
//		boolean result = true;
//		List<url> Lurl = new ArrayList<>();
//		
//		address = address==null?"":address;
//		
//		Lurl = urlrepo.findByStepidAndSizeAndAddress(stepid,size,address);
//		
//		if(Lurl.size()==0||Lurl == null) {
//			result = false;
//		}
//		
//		return result;
//	}
//	
//	public boolean createurl(int stepid,int size,String address,Date starttime,Date endtime) {
//		boolean result;
//		url Lurl = new url();
//		
//		try {
//			address = address==null?"":address;
//			
//			Lurl.setStepid(stepid);
//			Lurl.setSize(size);
//			Lurl.setAddress(address);
//			Lurl.setStarttime(starttime);
//			Lurl.setEndtime(endtime);
//			Lurl.setDuration(0);
//			
//			urlrepo.save(Lurl);
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
