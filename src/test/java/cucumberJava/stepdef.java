package cucumberJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import drivermanager.Driverbase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.UserPage;
import util.CommonFunctions;



public class stepdef extends Driverbase{ 
	WebDriver driver=Driverbase.getDriver("chrome");
	
	 private UserPage user = new UserPage(Driverbase.driver);
	 private CommonFunctions cf = new CommonFunctions(Driverbase.driver);
     
   @Given("^I have open the browser$") 
   public void openBrowser() { 
      
	   driver.manage().window().maximize();   
   } 
   
   @Given("^Launch url$") 
   public void launchURL() { 
	   driver.get("https://www.google.com");
   }
   
   @Given("^Enter text$") 
   public void enterText() throws IOException, InterruptedException { 
	   
	   
	   int count=cf.getRowNumber("Sheet1");
	   for(int i=0;i<count;i++) {
		   Thread.sleep(1000);
	       cf.sendText(user.get_txt_UserName(), cf.getdatafromExcel("Sheet1", i, 0));
	       user.get_txt_UserName().clear();
	   }
//	   cf.sendText(user.get_txt_UserName(),cf.getdatafromExcelBasedonColValue("Sheet1", "a10", 0));
   }
   
}