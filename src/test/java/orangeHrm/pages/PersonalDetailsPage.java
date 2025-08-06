package orangeHrm.pages;

import orangeHrm.utils.BrowserUtility;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPage extends BrowserUtility {

    private static final String PERSONAL_DETAILS_URL = "viewPersonalDetails/empNumber";

    public PersonalDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean validatePersonalDetailsUrl(){
        return getPageUrl().contains(PERSONAL_DETAILS_URL);
    }


}
