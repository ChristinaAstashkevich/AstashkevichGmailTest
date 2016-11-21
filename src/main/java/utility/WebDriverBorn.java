package utility;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverBorn {

    static WebDriver driver;

    public static WebDriver getDriver(String browserName, String url) throws MalformedURLException {

        System.setProperty("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setPlatform(Platform.VISTA);
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("45");



        if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("Remote")){
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(8, TimeUnit.SECONDS);
        driver.get(url);
        return driver;

    }


}
