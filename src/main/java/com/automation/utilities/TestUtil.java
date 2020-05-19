package com.automation.utilities;

import com.automation.commons.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil extends BaseClass {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICITLY_WAIT = 20;


    public static void takeScreenShot(String sClassName, String sMethodName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir") +
                "/src/main/java/com/automation/Screenshots/";
        FileUtils.copyFile(screenshot, new File(currentDir + sClassName
                + "_" + sMethodName + "_" + System.currentTimeMillis() + ".png"));
    }
}
