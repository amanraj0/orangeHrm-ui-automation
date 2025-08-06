package orangeHrm.pages;

import orangeHrm.constants.Browser;
import orangeHrm.utils.BrowserUtility;
import org.openqa.selenium.By;



public class LoginPage extends BrowserUtility {

    private static final By USERNAME_TEXT_LOCATOR = By.name("username");
    private static final By PASSWORD_TEXT_LOCATOR = By.name("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector("[class*='login-button']");



    public LoginPage(Browser browser) {
        super(browser);
        goToWebSite("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public DashboardPage doLoginWith(String username, String password){
        enterText(USERNAME_TEXT_LOCATOR,username);
        enterText(PASSWORD_TEXT_LOCATOR,password);
        clickOn(LOGIN_BUTTON_LOCATOR);
        return new DashboardPage(getDriver());
    }
}
