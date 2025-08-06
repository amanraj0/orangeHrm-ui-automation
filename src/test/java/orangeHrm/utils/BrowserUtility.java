package orangeHrm.utils;

import orangeHrm.constants.Browser;
import org.openqa.selenium.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class BrowserUtility extends Base {

    public BrowserUtility(Browser browser) {
        super(browser);
    }

    public BrowserUtility(WebDriver driver) {
        super(driver);
    }

    public void goToWebSite(String url){
        logger.info("Navigating to {}", url);
        getDriver().get(url);
    }

    public void enterText(By locator, String text){
        logger.info("Entering text: {} to {}",text, locator);
        WebElement element = getDriver().findElement(locator);
        element.sendKeys(text);
    }

    public void clickOn(By locator){
        logger.info("Clicking on {}", locator);
        WebElement element = getDriver().findElement(locator);
        element.click();
    }

    public void clickOn(WebElement element){
        logger.info("Clicking on {}", element);
        element.click();
    }

    public String getPageUrl(){
        logger.info("getting the current page title {}",getDriver().getCurrentUrl());
        return getDriver().getCurrentUrl();
    }

    public WebElement getElement(By locator,String text){
        logger.info("Searching for {} element in list of locator {}", text, locator);
        List<WebElement> menuItems = getDriver().findElements(locator);

        return menuItems.stream()
                .filter(menuItem -> menuItem.getText().equals(text))
                .findFirst()
                .orElseThrow(()->{
                    logger.debug("Invalid menu item provided {}", text);
                    return new IllegalArgumentException("Invalid menu item provided");
                });

    }

    public String takeScreenshot(String name){
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = sdf.format(date);
        String path = System.getProperty("user.dir") + "//screenshots//" + name + "-" + timeStamp + ".png";
        File screenshotFile = new File(path);
        try(
                FileInputStream fis = new FileInputStream(screenshotData);
                FileOutputStream fout = new FileOutputStream(screenshotFile);
                ){
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fout.write(buffer, 0, length);
            }

        }catch(IOException ioException){
            logger.error("Failed while copying screenshot , {}", ioException);
        }
        logger.info("screenshot created for failure test {}", path);
        return path;
    }

}
