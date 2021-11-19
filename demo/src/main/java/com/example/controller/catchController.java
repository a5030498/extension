package com.example.controller;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.common.io.Files;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies; 


@Controller
@RequestMapping(value = "/event")
public class catchController {
	
//	@Autowired
//	eventService eventser;
	List<String> action = new ArrayList<>();
	String openurl = "";
	@GetMapping("/CatchView")
    public String list() {
		System.out.println("---------------starting event---------------------");
    	return "CatchView";
    }
	@ResponseBody
	@PostMapping("/CatchEvent") 
	public String catchevent(String url){
		try {			
			ChromeOptions options = new ChromeOptions ();
			options.addExtensions (new File("C:\\Users\\eric.lin\\Desktop\\extension\\borderify.crx"));
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\eric.lin\\Desktop\\google driver\\chromedriver.exe");
	        LoggingPreferences logPrefs = new LoggingPreferences();
	        logPrefs.enable(LogType.BROWSER, Level.ALL);
			options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			options.setCapability("goog:loggingPrefs", logPrefs);
			options.addArguments();

					
			ChromeDriver driver = new ChromeDriver(options);	     
			driver.get(url);
			openurl = "{\"event\":\"open\",\"url\":\""+url+"\",\"value\":\"\"},";			
			//WebDriverWait wait = new WebDriverWait(driver,555555);//最多等5秒			
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("end")));
			System.out.println(driver.manage().logs());
			LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	        for (LogEntry entry : logEntries) {
	        	int i=entry.getMessage().indexOf("\"")+1;
	        	int z = entry.getMessage().lastIndexOf("\"");
	        	String x = entry.getMessage();
	        	if(i!=-1&&z!=-1) {
	        	System.out.println(entry.getMessage().substring(i, z));
	        	}
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "sucess";
	}
	@GetMapping("/init")
	public void init(){
		try {
			action.clear();
			System.out.println("init");
			System.out.println(action);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	@GetMapping("/storeFile")
	public void storeFile(){
		try {			
			 BufferedWriter recoder = new BufferedWriter(new FileWriter("C:\\Users\\eric.lin\\Desktop\\recoder\\recoder.txt")) ;        		
			 recoder.write("[");
			 recoder.write(openurl); 
			 recoder.write("\r\n"); 
			for(int i =0 ; i<action.size();i++) {
			 String data = action.get(i);
			 recoder.write(data);
			 if(i<action.size()-1) {recoder.write(",");}
			 recoder.write("\r\n"); 
			 System.out.println("write"+data);
			 }
			 recoder.write("]");
			 System.out.println("end");
			 recoder.flush();			        
			 recoder.close();
		}catch (Exception e) {
			e.printStackTrace();			
		}
	}
	@ResponseBody
	@CrossOrigin("*")
	@PostMapping("/storeEvent")
	public String storeevent(@RequestBody String test){
		try {
		System.out.println(test);
		action.add(test);
		//System.out.println(action);
		}catch (Exception e) {
			e.printStackTrace();			
		}		
		return "0";
	}
	@PostMapping(value="/storeEventJson")
	public String storejson(@RequestParam(name ="event",required=false) String event,
			@RequestParam(name ="className",required=false) String className,
			@RequestParam(name ="name",required=false) String name,
			@RequestParam(name ="id",required=false) String id,
			@RequestParam(name ="target",required=false) String target,
			@RequestParam(name = "value",required=false)String value){		
		System.out.println(event);
		System.out.println(id);
		System.out.println(name);
		System.out.println(className);
		System.out.println(target);
		System.out.println(value);
		System.out.println("sucess");		
		return "test";
		
	}
}
