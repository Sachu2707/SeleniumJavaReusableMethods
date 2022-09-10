package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class UserPage {

    private WebDriver driver;
    
    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement txt_UserName;
    
    public WebElement get_txt_UserName() {
    	return txt_UserName;
    }

  

}
