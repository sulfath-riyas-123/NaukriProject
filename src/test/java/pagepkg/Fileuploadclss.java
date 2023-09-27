package pagepkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fileuploadclss {
	WebDriver driver;
   By NKcomplteprofile =By.xpath("/html/body/main/div/div/div/div/div/div[1]/div/div[3]/div[2]");
  By Nkscreenclick=By.xpath("//*[@id=\"root\"]/div/div/span/div/div/div/div");
  By NKuploadresume=By.xpath("//*[@id=\"root\"]/div/div/span/div/div/div/div/div/div[2]/div[1]/div/div/ul/li[2]/a");
	public Fileuploadclss(WebDriver driver) {
		this.driver=driver;
	}
public void file() {
	driver.findElement(NKcomplteprofile).click();
	driver.findElement(Nkscreenclick).click();
	driver.findElement(NKuploadresume).click();
	//driver.navigate().refresh();
}
public void fileupload(String p) throws AWTException {
	StringSelection  strSelection=new StringSelection(p);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
	//to paste into system window
	Robot robot=new Robot();
	robot.delay(3000);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	
	robot.keyPress(KeyEvent.VK_ENTER);
	//THREAD.SLEEP(5000)
	robot.keyRelease(KeyEvent.VK_ENTER);
}
}	
	
	
	


