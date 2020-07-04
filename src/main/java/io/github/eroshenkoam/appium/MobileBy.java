package io.github.eroshenkoam.appium;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MobileBy extends By {

    private By android;
    private By ios;

    public MobileBy android(By selector) {
        this.android = selector;
        return this;
    }

    public MobileBy ios(By selector) {
        this.ios = selector;
        return this;
    }

    public List<WebElement> findElements(SearchContext searchContext) {
        return searchContext.findElements(getSelector());
    }

    public String toString() {
        return getSelector().toString();
    }

    private By getSelector() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        if (driver instanceof AndroidDriver) {
            return android;
        }
        if (driver instanceof IOSDriver) {
            return ios;
        }
        throw new RuntimeException("Driver must be Android or IOS");
    }

    public static MobileBy mobile() {
        return new MobileBy();
    }

}
