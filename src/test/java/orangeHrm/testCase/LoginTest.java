package orangeHrm.testCase;

import orangeHrm.listeners.TestListener;
import orangeHrm.pages.LoginPage;
import orangeHrm.utils.BrowserUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static orangeHrm.constants.Browser.*;

@Listeners(TestListener.class)
public class LoginTest {
    protected LoginPage loginPage;

    @BeforeClass
    public void setup(){
        loginPage = new LoginPage(CHROME);

    }

    @Test(
            priority = 0,
            description = "Verify that user is able to log in and moves to dashboard page"
    )
    public void loginWithValidUser(){
        boolean movedToDashboardPage = loginPage
                .doLoginWith("Admin","admin123")
                .validateDashboardUrl();

        Assert.assertTrue(movedToDashboardPage,"Logged in user didn't moved to Dashboard page");

    }

    public BrowserUtility getInstance(){
        return loginPage;
    }

    @AfterClass
    public void quit(){
        loginPage.getDriver().quit();
    }
}
