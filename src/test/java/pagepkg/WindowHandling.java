package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandling {
	WebDriver driver;
	By NKservice=By.xpath("/html/body/div[3]/div[2]/nav/ul/li[3]/a/div");
	public WindowHandling (WebDriver driver)
	{
		this.driver=driver;
	}
	public void handling()
	{
		driver.findElement(NKservice).click();
	}
	

}
