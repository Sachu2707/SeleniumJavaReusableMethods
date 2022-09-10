package util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

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
    	System.out.println(filepath);
    	try {
    	element.sendKeys(text);
    	}
    	catch(Exception e){
    	    screenShotCaptured();
    	}
    }
    
    public String getdatafromExcel(int sheetnumber, int rowNumber,int col) throws IOException {
    	XSSFSheet sheet = getWorkBook().getSheetAt(sheetnumber);
    	int rowCount = sheet.getLastRowNum();
		System.out.println("Total rows : "+rowCount);
		
		Row row=sheet.getRow(rowNumber); //returns the logical row  
		Cell cell=row.getCell(col); //getting the cell representing the given column  
		String usr=cell.getStringCellValue();//getting cell value  
		
		return usr;
    }

}
