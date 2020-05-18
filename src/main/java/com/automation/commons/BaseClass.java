package com.automation.commons;

import com.automation.utilities.TestUtil;
import com.automation.utilities.WebEventListerner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static Properties properties;
    public static WebEventListerner driverListener;
    public static EventFiringWebDriver webDriverEvent;

    public String sSystemPath;
//    public WebDriverWait wait;

    public BaseClass(){
        sSystemPath = System.getProperty("user.dir");
        System.out.println("System path is: " + sSystemPath);
        try{
            properties = new Properties();
            properties.load(new FileInputStream(sSystemPath +
                    "/src/main/java/com/automation/config/config.properties"));
        } catch (Exception e) {
            System.out.println("Properties file not present");
        }
    }

    public void setUp() {
        System.out.println("Browser used is: " + properties.getProperty("browser"));
        if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "G:\\Piyush\\Tools\\Chrome\\Chrome81.0.4044.138\\chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.chromedriver().
            driver = new ChromeDriver();
        } else if(properties.getProperty("browser") == "firefox") {
            System.setProperty("webdriver.gecko.driver", "");
            driver = new FirefoxDriver();
        } else {
            System.out.println("No property file found, not able to get bowser");
        }
//        wait = new WebDriverWait(driver, 15);
        webDriverEvent = new EventFiringWebDriver(driver);
        driverListener = new WebEventListerner();
        webDriverEvent.register(driverListener);

        driver = webDriverEvent;
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
    }

}
