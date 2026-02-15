package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {

    private WebDriver driver;

    private By nameField = By.name("name");
    private By emailField = By.name("email");
    private By messageField = By.name("message");
    private By sendButton = By.cssSelector("button[type='submit']");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void insertEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void insertMessage(String message) {
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSendButton() {
        driver.findElement(sendButton).click();
    }
}
