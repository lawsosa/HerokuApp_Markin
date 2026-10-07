package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxInputPage;

public class CheckBoxInputTest extends BaseTest {

    @Test
    public void shouldToggleBothCheckboxes() {

        CheckBoxInputPage page = new CheckBoxInputPage(webDriver);
        page.open();

        Assert.assertFalse(page.isFirstCheckBoxChecked(), "Первый чекбокс изначально не отмечен");
        page.clickFirstBox();
        Assert.assertTrue(page.isFirstCheckBoxChecked(), "Первый чекбокс должен стать отмеченным");

        Assert.assertTrue(page.isSecondCheckBoxChecked(), "Второй чекбокс изначально отмечен");
        page.clickSecondBox();
        Assert.assertFalse(page.isSecondCheckBoxChecked(), "Второй чекбокс должен стать не отмеченным");
    }
}
