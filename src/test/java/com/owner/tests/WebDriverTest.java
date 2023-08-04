package com.owner.tests;

import com.codeborne.selenide.Configuration;
import com.owner.config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class WebDriverTest {
    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.browserName();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
        if (config.isRemote()) {
            Configuration.remote = config.remoteUrl();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));

        Configuration.browserCapabilities = capabilities;
    }
    @Test
    public void testGithub() {
        open(Configuration.baseUrl);
        $(".application-main").shouldHave(text("Let’s build from here"));
    }


}