package evprimefrontendtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static utils.DateBuilder.currentTime;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000");
    }

    @Test
    public void baseTest() throws InterruptedException{
        driver.navigate();
        Thread.sleep(500);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
