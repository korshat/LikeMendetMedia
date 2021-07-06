package com.lmmv.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
     /*
    This method accepts List<WebElement> and returns List<Strings>
     */
    public static List<String> getElementsText(List<WebElement> webElementList){
        List<String> webElementAsString = new ArrayList<>();
        for(WebElement each : webElementList){
            webElementAsString.add(each.getText());
        }
      return webElementAsString;
    }

    public static void titleVerification(String expectedTitle){

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    //Switches to new window by the exact title. Returns to original window if target title not found

    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }
    //Moves the mouse to given element

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    //Waits for the provided element to be visible on the page

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

}
