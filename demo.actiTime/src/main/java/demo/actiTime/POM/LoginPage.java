package demo.actiTime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username") private WebElement userNameTextField;
	@FindBy(name="pwd") private WebElement passwordTextField;
	@FindBy(xpath="//div[text()='Login ']") private WebElement loginButton;

	public void login(String username, String password)
	{
		userNameTextField.sendKeys(username);;
		passwordTextField.sendKeys(password);
		loginButton.click();
	}

}
