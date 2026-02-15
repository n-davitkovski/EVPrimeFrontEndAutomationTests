package evprimefrontendtests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.ContactPage;
import pages.CreateEditEventPage;
import pages.CreateUserLoginPage;
import pages.SidePanel;

import static utils.DateBuilder.currentTime;

public class ContactPageTests {

    private SidePanel sidePanel;
    private ContactPage contactPage;
    private WebDriver driver;
    private ChromeOptions options;
    private CreateUserLoginPage createUserLoginPage;
    private CreateEditEventPage createEditEventPage;

    @Before
    public void initPages() {
        options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //sidePanel.navigateTo("http://localhost:3000");
        driver.get("http://localhost:3000");
        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);
        createEditEventPage = new CreateEditEventPage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test
    public void sendContactFormTest() throws InterruptedException{
        sidePanel.clickMenuIcon();
        Thread.sleep(500);
        sidePanel.clickLoginButton();

        String mail = currentTime() + "@mail.com";
        String password = "12345678";

        //create new user
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();

        //login
        Thread.sleep(4000);
        sidePanel.clickLoginButton();
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();

        sidePanel.clickLoginButton();
        createUserLoginPage.insertEmail(currentTime() + "@mail.com");
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();

        //go to event creation
        Thread.sleep(1000);
        sidePanel.hoverPlusSign();
        sidePanel.clickAddEventButton();

        //insert event information
        createEditEventPage.insertEventTitle("Car meet");
        createEditEventPage.insertEventImage("https://images.squarespace-cdn.com/content/v1/6598c8e83ff0af0197ff19f9/a05c7d5e-3711-48bb-a4c8-f3ce0f076355/JCCI-2024-Banner.jpg");
        createEditEventPage.insertEventDate("2025-12-07");
        Thread.sleep(5000);
        createEditEventPage.insertEventLocation("Parking sala Boris Trajkovski");
        createEditEventPage.insertEventDescription("The biggest car meet on the balkans");

        createEditEventPage.clickCreateUpdateEventButton();

        // navigate to Contact page
        sidePanel.clickContactButton();

        // submit
        contactPage.clickSendButton();
    }
}
