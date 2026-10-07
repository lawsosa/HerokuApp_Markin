package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

public class DropdownTest extends BaseTest {

    @Test
    public void shouldContainAllOptionsAndSelectThem() {

        DropdownPage page = new DropdownPage(webDriver);
        page.open();

        List<String> options = page.getAllOptions();

        Assert.assertEquals(options.size(), 3, "В списке должно быть три пункта");
        Assert.assertTrue(options.contains("Please select an option"), "Отсутствует пункт-плейсхолдер");
        Assert.assertTrue(options.contains("Option 1"), "Отсутствует Option 1");
        Assert.assertTrue(options.contains("Option 2"), "Отсутствует Option 2");

        page.selectOption1();
        Assert.assertTrue(page.isOption1Selected(), "Option 1 не выбран");

        page.selectOption2();
        Assert.assertTrue(page.isOption2Selected(), "Option 2 не выбран");
    }
}
