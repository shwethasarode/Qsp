package demo.actiTime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='content selected tt']") private WebElement timeTrackButton;
	@FindBy(xpath="//a[@class='content tasks']") private WebElement taskButton;
	@FindBy(xpath="//a[@class='content reports']") private WebElement reportsButton;
	@FindBy(xpath="//a[@class='content users']") private WebElement usersButton;
	@FindBy(id="logoutLink") private WebElement logoutLink;
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	public void setLogoutLink(WebElement logoutLink) {
		this.logoutLink = logoutLink;
	}
	
	
}

