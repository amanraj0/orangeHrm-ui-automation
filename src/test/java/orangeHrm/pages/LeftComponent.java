package orangeHrm.pages;

import orangeHrm.constants.MenuItems;
import orangeHrm.utils.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftComponent extends BrowserUtility {

    private static final By MENU_ITEM_LOCATOR = By.cssSelector("span[class*='menu-item']");

    public LeftComponent(WebDriver driver) {
        super(driver);
    }

    public void selectMenuItem(MenuItems menu){
        clickOn(getElement(MENU_ITEM_LOCATOR, menu.getMenuItem()));
    }
}
