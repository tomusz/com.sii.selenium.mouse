package com.sii.configuration;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import static com.sii.configuration.keys.MsgPropertiesKeys.*;

@Slf4j
public class WebListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.info(INFO_EVENT_LISTENER_BEFORE_CLICK);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        log.info(INFO_EVENT_LISTENER_AFTER_CLICK);
    }
}
