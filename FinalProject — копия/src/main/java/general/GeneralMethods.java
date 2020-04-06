package general;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralMethods extends DriverManager{
    //Метод ожидания появления элемента
    public static WebElement waitForElementPresentRefact(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),  timeoutInSeconds);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by) //ожидает элемент
        );
    }

    //Движение внутри элемента (движение влево)
    public static void swipeElementLeft(By by){
        //Ищем элемент
        WebElement element = waitForElementPresentRefact(by,5);

        //Определяем границы элемента

        //Получаем координаты верхнего левого угла элемента
        int left_x = element.getLocation().getX();
        int upper_y = element.getLocation().getY();

        //Находим верхнюю и нижнюю часть блока и делаем swipe по середине
        int right_x = left_x + element.getSize().getWidth();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) /2;

        //Все действие описываем внутри элемента
        //Здесь описывается движение по экрану влево
        TouchAction action = new TouchAction(DriverManager.getDriver());
        action
                .press(PointOption.point(right_x,middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(left_x,middle_y))
                .release()
                .perform();
    }

    public static void longPress(WebElement element){
        //Долгое нажатие
        AndroidTouchAction touch = new AndroidTouchAction (DriverManager.getDriver());
        touch.longPress(LongPressOptions.longPressOptions()
                .withElement (ElementOption.element (element)))
                .perform ();
        WebElement elementDelete = waitForElementPresentRefact(By.id("buttonRemoveList"),5);
        elementDelete.click();
        WebElement elementValidateDeleteList = waitForElementPresentRefact(By.id("validateDeleteList"),5);
        elementValidateDeleteList.click();
    }

    public static void rotateScreenLandScape(){
        DriverManager.getDriver().rotate(ScreenOrientation.LANDSCAPE);
    }

    public static void rotateScreenPortrait(){
        DriverManager.getDriver().rotate(ScreenOrientation.PORTRAIT);
    }



}