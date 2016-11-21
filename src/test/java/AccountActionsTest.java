import base.TestBase;
import org.testng.annotations.Test;
import utility.DataProvider;

public class AccountActionsTest extends TestBase {


    @Test(description = "GM-1 Login to gmail with valid credentials",
            dataProvider = "accountsData", dataProviderClass = DataProvider.class)
    public void logInTest(String login, String password) {
        loginPage.login(login, password)
                .goToHeader()
                .checkLogInSuccess();

    }

    @Test(description = "GM-2 Logout from gmail",
            dataProvider = "accountsData", dataProviderClass = DataProvider.class)
    public void logOutTest(String login, String password) {
        loginPage.login(login, password)
                .goToHeader()
                .signOut()
                .checkSignOutSuccess();
    }
}
