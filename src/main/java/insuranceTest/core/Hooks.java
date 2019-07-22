package insuranceTest.core;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {


    @Before
    public void beforeEach() {
        ReportHelper.addTestDescription("Запуск теста домашнего задания Шнайдер А.Е.");
    }


    /**
     * Спасибо Юра за это)
     */
    @Before("@fail")
    public void beforeTagged() {
        ReportHelper.addHtmlDescription(
                "<p><font color=\"red\">Тест упал</font></p>" +
                        "<form action=\"http://google.com\">\n" +
                        "    <input type=\"submit\" value=\"Пойти погуглить\" />\n" +
                        "</form>");
    }

    @After
    public void afterEach() {
        ReportHelper.addTextAttach("Тест успешно пройден");
    }

}
