package orangeHrm.pages;

import orangeHrm.utils.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage extends BrowserUtility {

    private static final String ADD_EMPLOYEE_URL = "pim/addEmployee";
    private static final By FIRST_NAME_TEXT_LOCATOR = By.name("firstName");
    private static final By LAST_NAME_TEXT_LOCATOR = By.name("lastName");
    private static final By SAVE_EMPLOYEE_DETAILS_LOCATOR = By.cssSelector("button[class*='left-space']");

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    public boolean validateAddEmployeeUrl(){
        return getPageUrl().contains(ADD_EMPLOYEE_URL);
    }

    public PersonalDetailsPage createEmployee(){
        enterText(FIRST_NAME_TEXT_LOCATOR,"Liana");
        enterText(LAST_NAME_TEXT_LOCATOR,"Corwin");
        clickOn(SAVE_EMPLOYEE_DETAILS_LOCATOR);
        return new PersonalDetailsPage(getDriver());

    }
}
