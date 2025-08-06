package orangeHrm.pages;

import orangeHrm.utils.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage extends BrowserUtility {
    private static final String PIM_URL = "pim/viewEmployeeList";
    private static final By ADD_EMPLOYEE_LOCATOR = By.cssSelector("i[class*='oxd-button-icon']");

    public PimPage(WebDriver driver) {
        super(driver);
    }

    public boolean validatePimUrl(){
        return getPageUrl().contains(PIM_URL);
    }



    public AddEmployeePage clickAddEmployee(){
        clickOn(ADD_EMPLOYEE_LOCATOR);
        return new AddEmployeePage(getDriver());
    }
}
