package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SidePanel extends BasePage {
    private By menuIcon = By.xpath("//*[@id=\"root\"]/div/div/header/div/button");
    private By eventsButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[2]/div/div[2]/span");
    private By loginButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[4]/div/div[2]/span");
    private By plusButton = By.xpath("//*[@id=\"root\"]/div/div[2]/button");
    private By addEventButton = By.xpath("//*[@id=\"SpeedDial-actions\"]/button");

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    public void clickMenuIcon(){
        clickElement(menuIcon);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public void hoverPlusSign(){
        hoverElement(plusButton);
    }

    public void clickAddEventButton(){
        clickElement(addEventButton);
    }

    public void clickContactButton() {
        
    }
}
