package orangeHrm.utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import orangeHrm.constants.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;



public abstract class Base {
    protected Logger logger = LoggerUtility.getLogger(this.getClass());

    private final WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    protected Base(WebDriver driver){
        this.driver = driver;
    }

    protected Base(Browser browser){
        logger.info("Test Cases will be executed in {}", browser);
        switch(browser){
            case CHROME:
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                logger.info("Instantiating chrome driver");
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                logger.info("Invalid browser provided: {}, initiating default browser chrome",browser);
                driver = new ChromeDriver();
        }
    }
}
