package util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivermanager.Driverbase;


public class CommonFunctions extends Driverbase {
	
    private WebDriver driver;
    String filepath=System.getProperty("user.dir");
    
    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
    }
    FileInputStream  fis;
    XSSFWorkbook workbook;
    
    public XSSFWorkbook getWorkBook() throws IOException {
    fis = new FileInputStream(filepath+"\\Excel\\Data.xlsx");
	return workbook = new XSSFWorkbook(fis);
    }
    
    public void screenShotCaptured() throws IOException {

    	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(filepath+"\\Screenshot\\homePageScreenshot.png"));
    }

    
    public void sendText(WebElement element, String text) throws IOException {
  
    	try {
    	element.sendKeys(text);
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    }
    
    public void getText(WebElement element) throws IOException {

    	try {
    	element.getText();
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    }
    
    public void clearText(WebElement element) throws IOException {
   
    	try {
    	element.clear();
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    }
    
    public void clickElement(WebElement element) throws IOException {
 
    	try {
    	element.click();
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    }
    
    public void selectbyValue(WebElement element, String val) throws IOException {
 
    	try {
    	Select sel=new Select(element);
    	sel.selectByValue(val);
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    }
    
    public void selectbyText(WebElement element, String val) throws IOException {

    	try {
    	Select sel=new Select(element);
    	sel.selectByVisibleText(val);
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    }
    
    public void selectbyIndex(WebElement element, int val) throws IOException {

    	try {
    	Select sel=new Select(element);
    	sel.selectByIndex(val);
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    }
    
    public Boolean isenabled(WebElement element) throws IOException {

    	try {
            element.isEnabled();
            
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    	return true;
    }
    
    public Boolean isdisplayed(WebElement element) throws IOException {

    	try {
            element.isDisplayed();
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    	return true;
    }
    
    public Boolean isselected(WebElement element) throws IOException {

    	try {
            element.isSelected();
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    	return true;
    }
    
    public void expicitwait(String xpath, int seconds) throws IOException {
    	try {
    		WebDriverWait wait = new WebDriverWait(driver,seconds);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    }
    
    public void implicitwait(int seconds) throws IOException {
    	try {
    		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    }
    
    @SuppressWarnings("deprecation")
	public void fluentwait(String xpath,int totalseconds, int pollingseconds) throws IOException {
    	try {
    		
    		FluentWait wait = new FluentWait(driver);	
    		wait.withTimeout(totalseconds, TimeUnit.MILLISECONDS);
    		wait.pollingEvery(pollingseconds, TimeUnit.MILLISECONDS);
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    }
    
    
    public String getdatafromExcel(String sheetname, int rownum,int col) throws IOException {
    	XSSFSheet sheet = getWorkBook().getSheet(sheetname);
    	int rowCount = sheet.getLastRowNum();
		System.out.println("Total rows : "+rowCount);
		
		Row row=sheet.getRow(rownum); //returns the logical row  
		Cell cell=row.getCell(col); //getting the cell representing the given column  
		String usr=cell.getStringCellValue();//getting cell value  
		
		return usr;
    }
    
    public String getdatafromExcelBasedonColValue(String sheetname, String rowText,int col) throws IOException {
    	XSSFSheet sheet = getWorkBook().getSheet(sheetname);
    	int rowCount = sheet.getLastRowNum();
    	int rownum=0;
		System.out.println("Total rows : "+rowCount);
		
		for(int i=0;i<rowCount;i++) {
			if(rowText.contentEquals(getdatafromExcel(sheetname, i, 0))){
				rownum=i;
				break;
			}
		}
		
		Row row=sheet.getRow(rownum); //returns the logical row  
		Cell cell=row.getCell(col); //getting the cell representing the given column  
		String usr=cell.getStringCellValue();//getting cell value  
		
		return usr;
    }
    
    public int getRowNumber(String sheetname)throws IOException {
    	XSSFSheet sheet = getWorkBook().getSheet(sheetname);
    	int rowCount = sheet.getLastRowNum();
    	return rowCount;
    }

}
