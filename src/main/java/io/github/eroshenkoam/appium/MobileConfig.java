package io.github.eroshenkoam.appium;

import org.aeonbits.owner.Config;
import org.openqa.selenium.Platform;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:${platform}.properties"})
public interface MobileConfig extends Config {

    @Config.DefaultValue("http://0.0.0.0:4723/wd/hub/")
    @Config.Key("mobile.remote.url")
    URL remoteURL();

    @Config.Key("mobile.app.location")
    String appLocation();

    @Config.Key("mobile.platform.name")
    Platform platformName();

    @Config.Key("mobile.platform.version")
    String platformVersion();

    @Config.Key("mobile.device.name")
    String deviceName();

    @Config.Key("mobile.device.orientation")
    String deviceOrientation();


}
