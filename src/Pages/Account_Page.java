package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_Page {
	
	WebDriver driver;
	
	@FindBy (xpath="//div[text()='COMPOSE']")
	WebElement compose;
	
	@FindBy (css="textarea[name='to']")
	WebElement rec;
	
	@FindBy (css="input.aoT")
	WebElement sub;
	
	@FindBy (css="div.Am.Al.editable.LW-avf")
	WebElement msgbody;
	
	@FindBy (xpath="//div[text()='Send']")
	WebElement send;
	
	
	public Account_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void composeEmail(){
		compose.click();
	}
	
	public void enterRec(){
		rec.click();
		rec.sendKeys("sarthak.mzn@gmail.com");
		rec.sendKeys(Keys.ENTER);
		
	}
	
	public void enterSub() throws Exception{
		Thread.sleep(5000);
		sub.click();
		sub.sendKeys("Test Email through Selenium Gmail-PageFactory");
	}
	
	public void entermsgBody(){
		msgbody.sendKeys("Test Email through Selenium Gmail-PageFactory");
	}
	
	public void sendEmail(){
		send.click();
	}
	
	
	
}
