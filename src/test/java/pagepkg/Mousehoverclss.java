package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mousehoverclss {
	WebDriver driver;
	By NKcompanies=By.xpath("/html/body/div[3]/div[2]/nav/ul/li[2]");
	By NKtopcompanies=By.xpath("/html/body/div[3]/div[2]/nav/ul/li[2]/div/ul[2]/li[2]/a");
	public Mousehoverclss(WebDriver driver) {
		this.driver=driver;
		
	}
	public void clickcomp() {
		driver.findElement(NKcompanies).click();;
	}
	public WebElement hover() {
		return driver.findElement(NKtopcompanies);
	}
	

}