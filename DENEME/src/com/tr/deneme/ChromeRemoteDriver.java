package com.tr.deneme;


import java.io.File;
import java.io.IOException;
import java.net.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeRemoteDriver {
    
    public static void main(String []args) throws MalformedURLException{
  	WebDriver driver ;
  	FirefoxProfile profile = new FirefoxProfile();  	
  	profile.setPreference("network.auth.force-generic-ntlm", false);
  	profile.setPreference("network.auth.force-generic-ntlm-v1", true);
  	profile.setPreference("network.automatic-ntlm-auth.allow-proxies", false);
  	profile.setPreference("network.proxy.type", 1);
  	profile.setPreference("network.proxy.http", "proxy2.uyap.gov.tr");     
  	profile.setPreference("network.proxy.http_port", 80);  
  	
    	System.setProperty("webdriver.firefox.marionette","geckodriver");
    	
    	driver = new FirefoxDriver(profile);    	
    	String baseUrl = "http://katalog.wunderfilter.com/AracSecimi.aspx";    	
        driver.get(baseUrl);    
      
        
    }
   }

