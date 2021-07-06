package com.lmmv.step_definitions;

import com.lmmv.pages.BasePage;
import com.lmmv.utilities.BrowserUtils;
import com.lmmv.utilities.ConfigurationReader;
import com.lmmv.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NavigationMenu {
    BasePage basePage;
    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @When("the user navigate to menu")
    public void the_user_navigate_to_menu() throws InterruptedException {
     Thread.sleep(2000);
        WebElement menu = BrowserUtils.waitForVisibility(basePage.menuButton,5);
       menu.click();


    }
    @When("the user click the aboutUs")
    public void the_user_click_the_about_us() {
    basePage.aboutUs.click();
    }
    @Then("the title should be MEET OUR TEAM")
    public void the_title_should_be_meet_our_team() {
        BrowserUtils.titleVerification("Like Minded Media Ventures");
    }

}
