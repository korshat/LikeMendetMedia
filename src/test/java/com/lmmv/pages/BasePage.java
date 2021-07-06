package com.lmmv.pages;

import com.lmmv.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id=\"menu-btn\"]")
    public WebElement menuButton;

    @FindBy(xpath = "/html/body/div/div/div[4]/div[2]/div/div[2]/a[1]")
    public WebElement aboutUs;
}
