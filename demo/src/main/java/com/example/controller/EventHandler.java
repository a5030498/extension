package com.example.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
 
public class EventHandler implements WebDriverEventListener{
 
 public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
 // TODO Auto-generated method stub
	 
 System.out.println("inside method afterChangeValueOf on " + arg0.toString());
 }
 public void beforeAlertAccept(WebDriver arg1){
 // TODO Auto-generated method stub
 
 System.out.println("inside method afterAlertAccept on " + arg1.toString());
 }
 public void beforeGetText(WebElement arg0,WebDriver arg1){
 // TODO Auto-generated method stub
 
 System.out.println("inside method afterAlertAccept on " + arg1.toString());
 }
 
 
 public void afterAlertAccept(WebDriver arg1){
 // TODO Auto-generated method stub
 
 System.out.println("inside method afterAlertAccept on " + arg1.toString());
 }
 public void beforeNavigateRefresh(WebDriver arg1){
 // TODO Auto-generated method stub
 
 System.out.println("inside method beforeNavigateRefresh on " + arg1.toString());
 }
 public void afterAlertDismiss(WebDriver arg1) {
 // TODO Auto-generated method stub
 
 System.out.println("inside method afterAlertDismiss on " + arg1.toString());
 }
 
 public void afterClickOn(WebElement arg0, WebDriver arg1) {
 // TODO Auto-generated method stub
 System.out.println("inside method afterClickOn on " + arg0.toString());
 }
 
 public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
 // TODO Auto-generated method stub
 System.out.println("Find happened on " + arg1.toString() 
 + " Using method " + arg0.toString());
 }
 
 public void afterNavigateBack(WebDriver arg0) {
 // TODO Auto-generated method stub
 
 System.out.println("Inside the after navigateback to " + arg0.getCurrentUrl());
 }
 
 public void afterNavigateForward(WebDriver arg0) {
 // TODO Auto-generated method stub
 System.out.println("Inside the afterNavigateForward to " + arg0.getCurrentUrl());
 }
 
 public void afterNavigateTo(String arg0, WebDriver arg1) {
 // TODO Auto-generated method stub
 System.out.println("Inside the afterNavigateTo to " + arg0);
 }
 
 public void afterScript(String arg0, WebDriver arg1) {
 // TODO Auto-generated method stub
 System.out.println("Inside the afterScript to, Script is " + arg0);
 }
 
 public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
 // TODO Auto-generated method stub
 
 System.out.println("Inside the beforeChangeValueOf method");
 }
 
 public void beforeClickOn(WebElement arg0, WebDriver arg1) {
 // TODO Auto-generated method stub
 System.out.println("About to click on the " + arg0.toString());
 
 }
 
 public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
 // TODO Auto-generated method stub
 System.out.println("Just before finding element " + arg0.toString());
 
 }
 
 public void beforeNavigateBack(WebDriver arg0) {
 // TODO Auto-generated method stub
 System.out.println("Just before beforeNavigateBack " + arg0.getCurrentUrl());
 
 }
 
 public void beforeNavigateForward(WebDriver arg0) {
 // TODO Auto-generated method stub
 System.out.println("Just before beforeNavigateForward " + arg0.getCurrentUrl());
 
 }
 
 public void beforeNavigateTo(String arg0, WebDriver arg1) {
 // TODO Auto-generated method stub
 System.out.println("Just before beforeNavigateTo " + arg0);
 }
 
 public void beforeScript(String arg0, WebDriver arg1) {
 // TODO Auto-generated method stub
 System.out.println("Just before beforeScript " + arg0);
 }
 
 public void onException(Throwable arg0, WebDriver arg1) {
 // TODO Auto-generated method stub
 System.out.println("Exception occured at " + arg0.getMessage());
 
 }
public void beforeAlertDismiss(WebDriver driver)
{
	System.out.println("test");// TODO Auto-generated method stub
	
}
public void afterNavigateRefresh(WebDriver driver)
{
	System.out.println("test");// TODO Auto-generated method stub
	
}
public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend)
{
	System.out.println("test");// TODO Auto-generated method stub
	
}
public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend)
{	System.out.println("test");
	// TODO Auto-generated method stub
	
}
public void beforeSwitchToWindow(String windowName, WebDriver driver)
{
	System.out.println("test");// TODO Auto-generated method stub
	
}
public void afterSwitchToWindow(String windowName, WebDriver driver)
{
	System.out.println("test");// TODO Auto-generated method stub
	
}
public <X> void beforeGetScreenshotAs(OutputType<X> target)
{
	System.out.println("test");// TODO Auto-generated method stub
	
}
public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot)
{
	System.out.println("test");// TODO Auto-generated method stub
	
}
public void afterGetText(WebElement element, WebDriver driver, String text)
{
	System.out.println("test");// TODO Auto-generated method stub
	
}
 
}