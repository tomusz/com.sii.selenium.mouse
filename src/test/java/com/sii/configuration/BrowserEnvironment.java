package com.sii.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.Optional;

import static com.sii.configuration.keys.PropertiesKeys.*;

@Slf4j
public class BrowserEnvironment {
    private String browserName;
    private boolean headlessBrowser;
    private int webElementTimeOut;
    private boolean attachScreenshot;
    private WebDriver driver;


    public BrowserEnvironment() {
        this.browserName = Optional.ofNullable(PropertyStore.getStringPropertyFromSystem(BROWSER_NAME))
                .orElse(PropertyStore.getStringPropertyFromSystem(DEFAULT_BROWSER_KEY));
        this.headlessBrowser = PropertyStore.getBooleanPropertyFromSystem(BROWSER_HEADLESS);
        this.webElementTimeOut = PropertyStore.getIntPropertyFromSystem(BROWSER_WEBELEMENT_TIMEOUT);
        this.attachScreenshot = PropertyStore.getBooleanPropertyFromSystem(BROWSER_ATTACH_SCREENSHOTS);
    }

    public WebDriver getDriver() {
        WebDriver driver;
        switch (this.browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                chromeOptions.addArguments("--start-maximised");
                driver = new ChromeDriver(chromeOptions);
                driver.get(System.getProperty(ENVIRONMENT_URL));
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions.addArguments("--start-maximised");
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                driver.get(System.getProperty(ENVIRONMENT_URL));
            default:
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(internetExplorerOptions);
                driver.manage().window().maximize();
                driver.get((System.getProperty(ENVIRONMENT_URL)));
        }
        this.driver = driver;
        return this.driver;
    }
}
