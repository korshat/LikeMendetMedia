package com.lmmv.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import javax.security.auth.login.Configuration;
import java.util.concurrent.TimeUnit;

public class Driver {
private Driver(){

}
private static WebDriver driver;

public static WebDriver getDriver(){
    String browser = ConfigurationReader.getProperty("browser");
    switch (browser){
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
        case "chrome-headless":
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
            break;
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
        case "firefox-headless":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
            break;
        case"ie":
            if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                throw new WebDriverException("Your OS support Internet Explore");
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            break;

    }

    return driver;
}

public static void closeDriver(){
    if (driver != null){
        driver.quit();
        driver = null;
    }
}
}
