package org.puneeth.StepDefinitionFile;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public Properties prop;

    @Before
    public void beforeTest() throws Exception {

        selectBrowser("chrome");

    }

    @After
    public void tearDown() {
        driver.quit();

    }

    public WebDriver selectBrowser(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public void propertiesFile(String data) throws Exception {
        prop = new Properties();
        String filePath = System.getProperty("user.dir") + "\\PropertiesFile\\InputData.properties";
        FileInputStream inputStream = new FileInputStream(filePath);
        prop.load(inputStream);
        inputStream.close();
        prop.getProperty(data);

    }
}
