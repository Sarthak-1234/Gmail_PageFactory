package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	WebDriver driver;
	
	
	@FindBy (id="Email")
	WebElement username;
	
	@FindBy (id="next")
	WebElement nextButton;
	
	@FindBy (id="Passwd")
	WebElement password;
	
	@FindBy (id="PersistentCookie")
	WebElement staySignIn;
	
	@FindBy (id="signIn")
	WebElement signIN;
	
	@FindBy (xpath="//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']")
	WebElement usernameAfterLogin;
	
	public Home_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(){
		username.sendKeys("sarthak.mzn");
	}
	
	public void nextButtonClick(){
		nextButton.click();
	}
	
	public void enterPassword(){
		password.sendKeys("................");
	}
	
	public void staySignInClick(){
		staySignIn.click(); //To not save password for future
	}
	
	public void signINClick(){
		signIN.click();
	}
	
	public String successfullLogin(){
		return usernameAfterLogin.getAttribute("title");
	}
	
	public String getHomePageText(){
		return driver.getTitle();
	}
	
}
