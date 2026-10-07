package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TyposPage;

public class TyposTest extends BaseTest {

    @Test
    public void shouldContainCorrectParagraphStart() {

        TyposPage page = new TyposPage(webDriver);
        page.open();

        String text = page.getTypoParagraphText();

        Assert.assertTrue(text.contains("Sometimes you'll see a typo"),
                "Текст параграфа не содержит ожидаемое начало");

        boolean matchesExpected =
                text.equals("Sometimes you'll see a typo, other times you won't.")
                        || text.equals("Sometimes you'll see a typo, other times you won,t.");

        Assert.assertTrue(matchesExpected, "Текст содержит неожиданные символы: " + text);
    }
}
