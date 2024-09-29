package org.puneeth.StepDefinitionFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utlities {
    public static WebDriver driver;

    public Utlities() {

    }

    public static By getByObject(String locatedTypeValue) {
        String locatedType = locatedTypeValue.split("~")[0];
        String locatedValue = locatedTypeValue.split("~")[1];
        By by;
        if (locatedType.equals("classname")) {
            by = By.className(locatedTypeValue);
        } else if (locatedType.equals("cssselector")) {
            by = By.cssSelector(locatedValue);
        } else if (locatedType.equals("id")) {
            by = By.id(locatedValue);
        } else if (locatedType.equals("linktext")) {
            by = By.linkText(locatedValue);
        } else if (locatedType.equals("name")) {
            by = By.name(locatedValue);
        } else if (locatedType.equals("partiallinktext")) {
            by = By.partialLinkText(locatedValue);
        } else if (locatedType.equals("tagname")) {
            by = By.tagName(locatedValue);
        } else {
            if (locatedType.equals("xpath")) {
                return null;
            }
            by = By.xpath(locatedValue);
        }
        return by;
    }

    public static WebElement getElement(String xpathValue) {

        try {
            waitForElement(xpathValue);
            driver.findElement(By.xpath(xpathValue));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void waitAndText(String pathValue, String inputValue) {

        try {
            waitForElement(pathValue);
            getElement(pathValue).sendKeys(inputValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void waitAndClick(String pathValue) {

        try {
            waitForElement(pathValue);
            getElement(pathValue).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitAndSelectByValue(String pathValue, String inputValue) {
        try {
            waitForElement(pathValue);
            WebElement selectValue = getElement(pathValue);
            Select sc = new Select(selectValue);
            sc.selectByValue(inputValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitAndSelectByIndex(String pathValue, int inputValue) {
        try {
            waitForElement(pathValue);
            WebElement selectValue = getElement(pathValue);
            Select sc = new Select(selectValue);
            sc.selectByIndex(inputValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitAndSelectByVisibleText(String pathValue, String inputValue) {
        try {
            waitForElement(pathValue);
            WebElement selectValue = getElement(pathValue);
            Select sc = new Select(selectValue);
            sc.selectByVisibleText(inputValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitAndAcceptAlert(String pathValue) {
        try {
            waitForElement(pathValue);
            waitAndClick(pathValue);
            driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitAndDismissAlert(String pathValue) {
        try {
            waitForElement(pathValue);
            waitAndClick(pathValue);
            driver.switchTo().alert().getText();
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitAndEnterValueAlert(String pathValue, String inputValue) {
        try {
            waitForElement(pathValue);
            waitAndClick(pathValue);
            driver.switchTo().alert().sendKeys(inputValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitAndGetText(String pathValue) {
        try {
            waitForElement(pathValue);
            getElement(pathValue).getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForElement(String pathValue) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathValue)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static String isElementPresent(String pathValue) {
        try {
            waitForElement(pathValue);
            getElement(pathValue).isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
