import java.util.*;
import java.io.*;

public class CreatePropertiesFile {
	
	public static void main(String[] args)throws Exception{  
	  
	Properties p=new Properties();  
	p.setProperty("Browser","Chrome"); 
	p.setProperty("Url","https://accounts.google.com/"); 
	p.setProperty("email","test360.233@gmail.com");  
	p.setProperty("Password","360logica");
	p.setProperty("UserName", "//input[@type='email']");
	p.setProperty("Nextbtn", "//span[@class='RveJvd snByac']");
	p.store(new FileWriter("info.properties"),"gmail Login Example");  
	  
	}  
	}  


