package io.github.eroshenkoam.appium;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileDriverProvider implements WebDriverProvider {

    private final MobileConfig config;

    public MobileDriverProvider() {
        this.config = ConfigFactory.newInstance().create(MobileConfig.class, System.getProperties());
    }

    @Override
    public WebDriver createDriver(final DesiredCapabilities capabilities) {
        capabilities.setCapability("platformName", config.platformName());
        capabilities.setCapability("platformVersion", config.platformVersion());
        capabilities.setCapability("deviceName", config.deviceName());
        capabilities.setCapability("deviceOrientation", config.deviceOrientation());
        capabilities.setCapability("build", "Java-TestNG-Appium-iOS");
        capabilities.setCapability("app", config.appLocation());

        if (config.platformName().equals(Platform.IOS)) {
            return new IOSDriver<>(config.remoteURL(), capabilities);
        }
        if (config.platformName().equals(Platform.ANDROID)) {
            return new AndroidDriver<>(config.remoteURL(), capabilities);
        }
        throw new UnsupportedOperationException("No such driver for platform: " + config.platformName());
    }
}
