package evprimefrontendtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CreateUserLoginPage;
import pages.SidePanel;

import static utils.DateBuilder.currentTime;

public class CreateUserLoginTest {
    private WebDriver driver;
    private ChromeOptions options;
    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;

    @Before
    public void initPages() {
        options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000");

        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);
    }

    @Test
    public void createUserTest() throws InterruptedException {

        sidePanel.clickMenuIcon();
        Thread.sleep(500);
        sidePanel.clickLoginButton();

        // switch to register mode
        createUserLoginPage.clickChangeStateButton();

        String email = currentTime() + "@mail.com";
        String password = "12345678";

        createUserLoginPage.insertEmail(email);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();

        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
