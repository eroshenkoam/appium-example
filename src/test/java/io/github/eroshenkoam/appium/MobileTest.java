package io.github.eroshenkoam.appium;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.$;

public class MobileTest {

    private final By header = MobileBy.mobile()
            .android(By.id("Heading1_1"))
            .ios(By.id("h1Text"));

    private final By commentText = MobileBy.mobile()
            .android(By.id("your_comments"))
            .ios(By.id("submittedComments"));

    private final By commentInput = MobileBy.mobile()
            .android(By.id("comments"))
            .ios(By.id("comments"));

    private final By submitButton = MobileBy.mobile()
            .android(By.id("submit"))
            .ios(By.id("submit"));

    @BeforeEach
    public void initDriver() {
        System.setProperty("platform", "ios");
        WebDriver driver = new MobileDriverProvider().createDriver(new DesiredCapabilities());
        WebDriverRunner.setWebDriver(driver);
    }

    @Test
    public void simpleTest() {
        final String comment = "Allure Rules!!!";

        $(commentInput).click();
        $(commentInput).sendKeys(comment);
        $(header).click();
        $(submitButton).click();
        $(commentText).should(Condition.text(comment));
    }

    @AfterEach
    public void quitDriver() {
        WebDriverRunner.closeWebDriver();
    }

}
