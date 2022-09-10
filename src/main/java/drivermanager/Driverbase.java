package drivermanager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class Driverbase {

    public static WebDriver driver;
    static String filepath=System.getProperty("user.dir");

    public static WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", filepath+"\\Driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", filepath+"\\Driver\\GeckoDriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", filepath+"\\Driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equals("safari")) {
            System.setProperty("webdriver.safari.driver", filepath+"\\Driver\\Safaridriver.exe");
            driver = new SafariDriver();
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}




