package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NotificationMessagesPage;

public class NotificationMessagesTest extends BaseTest {

    @Test
    public void shouldShowExpectedNotificationAfterClick() {

        NotificationMessagesPage page = new NotificationMessagesPage(webDriver);
        page.open();

        page.clickNotificationLink();

        String message = page.getNotificationText();

        Assert.assertTrue(message.contains("Action successful")
                        || message.contains("Action unsuccesful"),
                "Неизвестное сообщение: " + message);
    }
}
