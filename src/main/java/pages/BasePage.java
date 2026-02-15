package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public abstract class BasePage {
   public WebDriver driver;
   public Actions actions;

   public BasePage(WebDriver driver){
       this.driver = driver;
       actions = new Actions(driver);
   }

   public void navigateTo(String url){
       driver.get(url);
   }

   public void clickElement(By element){
       driver.findElement(element).click();
   }

   public void insertText(By element, String text){
       driver.findElement(element).sendKeys(text);
   }

   public void hoverElement(By element){
       WebElement webElement = driver.findElement(element);
       actions.moveToElement(webElement).perform();
   }

   public String getTextFromElement(By element){
       return driver.findElement(element).getText();
   }
}
