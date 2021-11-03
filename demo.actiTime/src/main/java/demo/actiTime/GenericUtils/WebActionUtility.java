package demo.actiTime.GenericUtils;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtility {
WebDriver driver;
JavascriptExecutor js;
Actions action;
public WebActionUtility(WebDriver driver) {
	this.driver= driver;
	js=(JavascriptExecutor)driver;
	action= new Actions(driver);
}
 public void enterData(WebElement targerElement, String keysToEnter) {
	 targerElement.clear();
	 targerElement.sendKeys(keysToEnter);
 }
 
 public void clickOnElement(WebElement targerElement) {
	 targerElement.click(); 
 }
 
 public void jsClick(WebElement targerElement) {
	 js.executeAsyncScript("arguments[0].click()",targerElement);
 }
 
 public void enterJsData(WebElement targerElement, String keysToEnter) {
	 js.executeAsyncScript("arguments[0].value='"+keysToEnter+"'", targerElement);
 }
 
 public void mouseHovering(WebElement targerElement) {
	 action.moveToElement(targerElement).perform();
 }
 
 public void rightClick(WebElement targerElement) {
	 action.contextClick(targerElement).perform();
 }
 
 public void doubleClick(WebElement targerElement) {
	 action.doubleClick(targerElement).perform();
 }
 
 public void dragAndDrop(WebElement source, WebElement destination) {
	 action.dragAndDrop(source, destination).perform();
 }
 
 public void waitAndClick(WebElement targerElement) {
	 WebDriverWait wait= new WebDriverWait(driver,10);
	 wait.until(ExpectedConditions.visibilityOf(targerElement));
	 targerElement.click();
 }
 
 public void switchToFrame(int index) {
	 driver.switchTo().frame(index);
 }
 
 public void switchToFrame(String idOrName) {
	 driver.switchTo().frame(idOrName);
 }
 
 public void switchToFrame(WebElement targerElement) {
	 driver.switchTo().frame(targerElement);
 }
 
public List<WebElement> getDropDowmElement(WebElement dropDown){
	Select select= new Select(dropDown);
	return select.getOptions();
}
}
