package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageBase {

    protected WebDriver driver;
    protected Actions builder;
    protected WebDriverWait wait;


    public PageBase(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
}


