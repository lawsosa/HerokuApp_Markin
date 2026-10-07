package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InputsPage;

public class InputsTest extends BaseTest {

    @Test
    public void shouldAcceptDigitsAndRejectLetters() {

        InputsPage page = new InputsPage(webDriver);
        page.open();

        page.enterValue("123");
        Assert.assertEquals(page.getValue(), "123", "Цифры должны вводиться в поле");

        page.clearInput();

        page.enterValue("abc");
        Assert.assertEquals(page.getValue(), "", "Буквы не должны попадать в поле");
    }

    @Test
    public void shouldChangeValueWithArrowKeys() {

        InputsPage page = new InputsPage(webDriver);
        page.open();

        page.enterValue("5");

        page.pressArrowUp();
        Assert.assertEquals(page.getValue(), "6", "Стрелка вверх должна увеличить значение");

        page.pressArrowDown();
        Assert.assertEquals(page.getValue(), "5", "Стрелка вниз должна уменьшить значение");
    }
}
