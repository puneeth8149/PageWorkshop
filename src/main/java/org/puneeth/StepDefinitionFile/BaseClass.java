package org.puneeth.StepDefinitionFile;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.puneeth.Utilities.PropertiesFile;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;


    @Before
    public void beforeTest() throws Exception {

        if (PropertiesFile.prop.getProperty("BrowserType").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (PropertiesFile.prop.getProperty("BrowserType").equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(PropertiesFile.prop.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();

    }
}

