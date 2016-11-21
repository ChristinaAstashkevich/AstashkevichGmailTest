package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MailPage;
import ru.yandex.qatools.allure.annotations.Attachment;
import utility.WebDriverBorn;

import java.net.MalformedURLException;

public class TestBase {

    public WebDriver driver;
    private final String BASE_URL = "https://gmail.com";
    private final String DRIVER_NAME = "Chrome";
    protected LoginPage loginPage;
    protected MailPage mailPage;

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = WebDriverBorn.getDriver(DRIVER_NAME, BASE_URL);
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
    }


    @AfterMethod
    public void teardown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
