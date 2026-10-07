package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void shouldAddTwoElementsAndCountDeletes() {

        AddRemoveElementsPage page = new AddRemoveElementsPage(webDriver);
        page.navigateToPage();

        page.clickAddButton();
        page.clickAddButton();

        int deleteButtons = page.getDeleteButtonsCount();

        Assert.assertEquals(deleteButtons, 2, "После двух кликов должно появиться два элемента Delete");
        System.out.println("Количество кнопок Delete: " + deleteButtons);
    }
}
