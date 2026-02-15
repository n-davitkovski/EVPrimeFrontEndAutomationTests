package evprimefrontendtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.SidePanel;

public class SidePanelTest {

    private WebDriver driver;
    private ChromeOptions options;
    private SidePanel sidePanel;

    @Before
    public void initPages() {
        options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000");

        sidePanel = new SidePanel(driver);
    }

    @Test
    public void navigateToLoginTest() throws InterruptedException {
        sidePanel.clickMenuIcon();
        Thread.sleep(500);
        sidePanel.clickLoginButton();

        Thread.sleep(1000);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
