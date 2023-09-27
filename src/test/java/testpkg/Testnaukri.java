package testpkg;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import basepkg.Baseclss;
import pagepkg.Fileuploadclss;
import pagepkg.Mousehoverclss;
import pagepkg.WindowHandling;
import pagepkg.loginclass;
import utilitiespkg.Excelutil;

public class Testnaukri extends Baseclss{
	
	@Test
	public void setup() throws InterruptedException, AWTException, IOException{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		loginclass nk=new loginclass (driver);
		String xl="E:\\datadriven\\LimeRoad.xlsx";
		String sheet="Sheet1";
		int rowCount=Excelutil.getRowCount(xl, sheet);
		nk.loginclik();
		for(int i=1;i<=rowCount;i++) {
			String username=Excelutil.getCellValue(xl,sheet,i,0);
			System.out.println("username---"+username);
			String password=Excelutil.getCellValue(xl,sheet,i,1);
			System.out.println("password---"+password);
			Thread.sleep(3000);
			nk.login(username, password);
			Thread.sleep(3000);
			nk.click();
			
			}
		Thread.sleep(3000);
		Mousehoverclss mh=new Mousehoverclss(driver);
		mh.clickcomp();
		Thread.sleep(3000);
		WebElement topcompanies=mh.hover();
		Actions act=new Actions(driver);
		act.moveToElement(topcompanies);
		act.perform();
		Thread.sleep(3000);

		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//to take screenshot
		FileHandler.copy(src, new File("./screenshort1//naukri.png"));
		driver.navigate().refresh();

		Thread.sleep(5000);
		WindowHandling wh=new WindowHandling(driver);
		  String parentwindow = driver.getWindowHandle();
	        System.out.println("parent window tittle"+driver.getTitle());
		wh.handling();
		Thread.sleep(3000);
		   Set<String> allwindowhandles = driver.getWindowHandles();
	       for(String handle:allwindowhandles)
	       {
	    	   System.out.println(handle);
	    	   if(!handle.equalsIgnoreCase(parentwindow))
	    	   {
	    		   driver.switchTo().window(handle);
	    		   driver.close();
	    	   }
	    	   driver.switchTo().window(parentwindow);
	       }
			
	   		Fileuploadclss fu=new Fileuploadclss(driver);
	   		fu.file();
	   		
	   		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   		driver.navigate().refresh();
	   	  
	   		driver.navigate().back();
	   		//ChromeOptions opt=new ChromeOptions();
	   		//opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
	   		// driver=new ChromeDriver(opt);
	   		fu.fileupload("C:\\Users\\USER\\Downloads\\Sulfath_C_A_-_Software_Tester new.pdf");
	} 
}