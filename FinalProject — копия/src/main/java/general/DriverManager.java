package general;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class DriverManager {
    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver(){
        return driver;
    }

    //Я убрала MobileElement,как тип AndroidDriver(треугольные скобки) и тесты пошли
    public static void initializeDriver(URL url, DesiredCapabilities capabilities){
        driver = new AndroidDriver<MobileElement>(url, capabilities);
    }
}
