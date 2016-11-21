package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#Email")
    private WebElement loginField;
    @FindBy(css = "#next")
    private WebElement nextButton;
    @FindBy(css = "#Passwd")
    private WebElement passwordField;
    @FindBy(css = "#signIn")
    private WebElement signInButton;
    @FindBy(css = "#PersistentCookie")
    private WebElement stayInCheck;


    public MailPage login(String login, String password) {
        loginField.clear();
        loginField.sendKeys(login);
        nextButton.click();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        if (stayInCheck.isSelected()){
            stayInCheck.click();
        }
        signInButton.click();
        return new MailPage(driver);
    }

    public LoginPage checkSignOutSuccess() {
        Assert.assertTrue((driver.getTitle().toString().contains("Gmail")));
        return this;
    }

}
