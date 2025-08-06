package orangeHrm.pages;


import orangeHrm.utils.BrowserUtility;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BrowserUtility {

    private static final String DASHBOARD_URL = "dashboard/index";

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateDashboardUrl(){
        return getPageUrl().contains(DASHBOARD_URL);
    }

    public LeftComponent getLeftComponentInstance(){
        return new LeftComponent(getDriver());
    }
}
