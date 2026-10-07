package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

public class HoversTest extends BaseTest {

    private static final String[] EXPECTED_NAMES = {"name: user1", "name: user2", "name: user3"};

    @Test
    public void shouldHoverOverEveryProfileAndOpenItsLink() {

        HoversPage page = new HoversPage(webDriver);
        page.open();

        for (int i = 0; i < EXPECTED_NAMES.length; i++) {
            page.hoverOverProfile(i);

            Assert.assertEquals(page.getProfileName(i), EXPECTED_NAMES[i],
                    "Имя профиля не совпадает с ожидаемым");

            page.clickProfileLink(i);

            Assert.assertFalse(page.getCurrentUrl().contains("404"),
                    "Страница профиля вернула 404");

            page.open();
        }
    }
}
