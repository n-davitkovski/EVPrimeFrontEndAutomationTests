package evprimefrontendtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreateEditEventPage;
import pages.CreateUserLoginPage;
import pages.SidePanel;

import java.time.Duration;

import static org.junit.Assert.*;
import static utils.DateBuilder.currentTime;

public class DeleteEventTests {
    private WebDriver driver;
    private ChromeOptions options;
    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;
    private CreateEditEventPage createEditEventPage;

    @Before
    public void setUp(){
        options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //sidePanel.navigateTo("http://localhost:3000");
        driver.get("http://localhost:3000");
        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);
        createEditEventPage = new CreateEditEventPage(driver);
    }

    @Test
    public void deleteEventTest() throws InterruptedException {

        sidePanel.clickMenuIcon();
        Thread.sleep(500);
        sidePanel.clickLoginButton();

        String mail = currentTime() + "@mail.com";
        String password = "12345678";

        // ✅ Register new user
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();

        // ✅ Login
        Thread.sleep(3000);
        sidePanel.clickLoginButton();
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();

        // ✅ Go to create event
        Thread.sleep(1000);
        sidePanel.hoverPlusSign();
        sidePanel.clickAddEventButton();

        // ✅ Create event
        createEditEventPage.insertEventTitle("Delete Test Event");
        createEditEventPage.insertEventImage("https://example.com/image.jpg");
        createEditEventPage.insertEventDate("2025-12-07");
        Thread.sleep(2000);
        createEditEventPage.insertEventLocation("Test Location");
        createEditEventPage.insertEventDescription("Event to be deleted");

        createEditEventPage.clickCreateUpdateEventButton();

        // ✅ Wait for event to be created
        Thread.sleep(3000);

        // ✅ Navigate to events list / homepage
        sidePanel.clickHomeButton(); // or wherever your events are listed

        Thread.sleep(2000);

        // ✅ Open the created event (you need a method for this)
        createEditEventPage.openEventByTitle("Delete Test Event");

        Thread.sleep(2000);

        // ✅ Click delete
        createEditEventPage.clickDeleteEventButton();

        // Check if alert appears
        boolean alertAppeared = false;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.alertIsPresent());
            alertAppeared = true;
        } catch (TimeoutException e) {
            alertAppeared = false;
        }

        System.out.println("Alert appeared: " + alertAppeared);

        // ✅ Confirm delete (if you have confirmation dialog)
        createEditEventPage.confirmDelete();

        Thread.sleep(2000);

        System.out.println("URL: " + driver.getCurrentUrl());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("events"));

        // ✅ OPTIONAL: verify event is gone
        boolean exists = createEditEventPage.isEventPresent("Delete Test Event");

        assertFalse("Event should be deleted", exists);
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
