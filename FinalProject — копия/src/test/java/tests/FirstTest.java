package tests;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import pages.MainPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class FirstTest extends BaseTest{
    MainPage mainPage = new MainPage();

    @Test(priority = 0)
    @Description(value = "Итоговая работа")
    @Epic("Проект #1")
    @Story("Создание в OneList")
    public void creatureTest() throws InterruptedException {
        //MainPage mainPage = new MainPage();
        //1) Откройте вкладку "TODO". Там будет надпись "Enjoy the app!"
        mainPage.openListTODO();
        //2) Проведите справа налево, чтобы удалить это напоминание.
        mainPage.swipeEnjoyElement();
        //3) Переместите фокус в поле ввода "Add"
        mainPage.clickListAdd();
        //4) Введите текст "Reminder 1" и нажмите кнопку ввода, чтобы его добавить
        mainPage.editText("Reminder 1");
        //5) Нажмите на кнопку "+" в правом верхнем углу
        mainPage.clickPlusButton();
        //6) Введите в поле ввода "List 1"
        mainPage.inputNameList();
        //7) Создайте в вкладке "List 1" напоминание "Reminder 2"
        mainPage.editText("Reminder 2");
    }


    @Test(priority = 1, enabled = false)
    @Description(value = "Итоговая работа")
    @Epic("Проект #1")
    @Story("Модификация в OneList")
    public void modificationTest() throws InterruptedException {
        //1) Отметьте как выполненное Напоминание "Reminder 2" во вкладке "List 1"
        mainPage.markAsDoneReminder("Reminder 2");
        //2) Перейдите во вкладку "TODO"
        mainPage.openListTODO();
        //3) Отметьте как выполненное "Reminder 1"
        mainPage.markAsDoneReminder("Reminder 1");
        //4) Удалите вкладку по умолчанию "Tuto?" с помощью долгого нажатия и выбора кнопки с корзиной в правом верхнем углу
        mainPage.deleteListTuto();
    }

    @Test(priority = 3)
    @Description(value = "Итоговая работа")
    @Epic("Проект #1")
    @Story("Share в OneList")
    public void shareTest() throws IOException, UnsupportedFlavorException {
        //1) Быть во вкладке "List 1"
        mainPage.openUserList();
        //2) Нажать кнопку рядом с "+" - ("Поделиться"/Share)
        mainPage.shareList();
        //3) Нажать "Copy"
        mainPage.clickButtonShare();
        //4) Проверить с помощью команды Appium driver.getClipboardText() наличие текста в буфере обмена
        // и что в нем отображено содержимое вкладки "List 1"
        //ищет несколько слов
        System.out.println("Ищем несколько слов");
        String[] strReminder = {"vika","x Reminder 2"};
        mainPage.findArrayTextOfList(strReminder);
        //ищет одно слово
        System.out.println("Ищем одно слово");
        mainPage.findTextOfListRefact("x Reminder 2");
    }

    @Test(priority = 2)
    @Description(value = "Итоговая работа")
    @Epic("Проект #1")
    @Story("Проверка и переворот экрана в OneList")
    public void checkFlipScreen() {
        //1)  Откройте список "List 1"
        mainPage.openUserList();
        //2) Переверните экран в ландшафтный режим
        mainPage.rotateScreenLandScape();
        //3) Проверьте наличие элемента "Reminder 2"
        mainPage.searchingElementInList("Reminder 2");
    }
}
