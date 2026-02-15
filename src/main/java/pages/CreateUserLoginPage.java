package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateUserLoginPage extends BasePage{

    private By formTitle = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div/div/form/div/div[1]");
    private By emailTextBox = By.name("email");
    private By passwordTextBox = By.name("password");
    private By goButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div/div/form/div/div[4]/div[1]/button");
    private By changeStateButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div/div/form/div/div[4]/div[2]/button");

    public CreateUserLoginPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText(){
        return getTextFromElement(formTitle);
    }

    public void insertEmail(String value){
        insertText(emailTextBox, value);
    }

    public void clickGoButton(){
        clickElement(goButton);
    }

    public void clickChangeStateButton(){
        clickElement(changeStateButton);
    }

    public void insertPassword(String value){
        insertText(passwordTextBox, value);
    }
}
