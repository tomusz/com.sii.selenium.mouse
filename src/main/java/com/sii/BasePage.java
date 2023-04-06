package com.sii;

import com.sii.configuration.PropertyStore;
import com.sii.configuration.WebListener;
import com.sii.configuration.keys.PropertiesKeys;
import com.sii.configuration.properties.PropertiesProvider;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static com.sii.configuration.keys.MsgPropertiesKeys.*;

@Slf4j
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Properties msgProperties = PropertiesProvider.getInfoMsgProperties();
    private EventFiringMouse eventFiringMouse;
    private WebListener webListener = new WebListener();


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(
                PropertyStore.getIntPropertyFromSystem(PropertiesKeys.BROWSER_WEBELEMENT_TIMEOUT)));
        PageFactory.initElements(driver, this);
    }

    public void clickOnButton(WebElement element) {
        String webElementText = element.getText();
        waitElementToBeClickable(element);
        element.click();
        log.info(String.format(msgProperties.get(ELEMENT_CLICKED_KEY).toString(), webElementText));
    }

    private void waitElementToBeClickable(WebElement element) {
        log.info(String.format(msgProperties.getProperty(WAIT_FOR_ELEMENT_TO_BE_CLICKABLE_KEY),
                element.getText()));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void waitForElementToBeVisible(WebElement element) {
        log.info(String.format(msgProperties.getProperty(WAIT_FOR_ELEMENT_TO_BE_VISIBLE_KEY),
                element.getText()));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void mouseHover(WebElement element) {
        waitForElementToBeVisible(element);
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
        log.info(String.format(msgProperties.getProperty(MOUSE_MOVED_TO_ELEMENT_KEY),
                element.getText()));
    }

    public void mouseClick(WebElement element) {
        waitForElementToBeVisible(element);
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.click(coordinates);
        log.info(String.format(msgProperties.getProperty(ELEMENT_CLICKED_KEY),
                element.getText()));
    }
}