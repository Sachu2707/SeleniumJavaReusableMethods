package cucumberJava;
 

import io.cucumber.testng.CucumberOptions;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import drivermanager.Driverbase;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(tags = "@VedioUpload", 
features = "src/test/java/cucumberJava/", 
glue = "cucumberJava")

public class runTest extends AbstractTestNGCucumberTests { 

}