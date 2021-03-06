package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static utility.Random.getRandomStringEng;

public class MailPage extends PageBase {

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public static String subject = getRandomStringEng(10);
    public static String message = getRandomStringEng(50);

    @FindBy(xpath = ".//div[@role='button' and text()='COMPOSE']")
    private WebElement composeButton;
    @FindBy(xpath = "//div[@role='navigation']//a[contains(text(),'Inbox')]")
    private WebElement inboxButton;
    @FindBy(xpath = "//div[@role='navigation']//a[contains(text(),'Sent Mail')]")
    private WebElement sentMailButton;
    @FindBy(xpath = "//div[@role=\"navigation\"]//span[text()='More']")
    private WebElement moreButton;
    @FindBy(xpath = "//a[@title='Trash']")
    private WebElement trashButton;
    @FindBy(xpath = "//div[@role='navigation']")
    private WebElement navigationBar;
    @FindBy(xpath = ".//div[@role='button' and @data-tooltip='Refresh']")
    private WebElement refreshButton;
    //@FindBy(xpath = ".//div[@role='button' and @aria-label='Delete']//div[@class='asa']")
    @FindBy(xpath = ".//*[@id=':a']/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div/div")
    private WebElement deleteMessageButton;
    @FindBy(xpath = "//button[@name='ok' and text()='OK']")
    private WebElement popUpOkButton;
    @FindBys({@FindBy(xpath = ".//div[@role='main']//tbody/tr//div[@role='link']//span[@id]")})
    private List<WebElement> listOfLetters;


    public Header goToHeader() {
        return new Header(driver);
    }

    public NewLetterWindow goToSendingNewLetter() {
        composeButton.click();
        return new NewLetterWindow(driver);

    }

    public MailPage goToInputMessages() {
        inboxButton.click();
        return this;
    }

    public MailPage goToSentLetters() {
        sentMailButton.click();
        return this;
    }

    public MailPage goToTrash() {
        builder = new Actions(driver);
        builder.moveToElement(navigationBar)
                .moveToElement(moreButton).click()
                .click(trashButton)
                .build().perform();
        return this;
    }

    public Boolean verifyMail() {
        for (WebElement mail : listOfLetters) {
            mail.getText().contains(subject);
            return true;
        }
        return true;
    }

    public MailPage deleteAndVerifyCurrentMessage() {
        goToSentLetters();
        driver.findElement(By.xpath("//span[(text() ='" + subject + "')]/../../../../..//div[@role = 'checkbox']")).click();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(deleteMessageButton));
        deleteMessageButton.click();
        popUpOkButton.click();
        goToTrash()
                .verifyMail();
        return this;
    }

}
