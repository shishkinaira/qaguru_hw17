package com.owner.tests;

import com.owner.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("property")
@Tag("remote")
public class WebDriverTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }

    @Test
    public void testGithub() {

        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }

}