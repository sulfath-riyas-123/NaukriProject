package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basepkg.Baseclss;

public class loginclass extends  Baseclss{
	WebDriver driver;
	//By NKsection=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]");
	By NKlogin=By.xpath("//*[@id=\"login_Layer\"]");
	By NKemail=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input");
	By NKpassword=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input");
	By NKloginbutton=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button");
	
	public loginclass(WebDriver driver) {
		this.driver=driver;
	}
  public void loginclik()
  {
	// driver.findElement(NKsection).click();
	 driver.findElement(NKlogin) .click();
  }
  public void login(String username,String password) {
	 driver.findElement(NKemail).clear();
	 driver.findElement(NKemail).sendKeys(username);
	 driver.findElement(NKpassword).clear();
	 driver.findElement(NKpassword).sendKeys(password);
  }
  public void click() {
	  
	 driver.findElement(NKloginbutton).click();
	
  }
  
 
}
