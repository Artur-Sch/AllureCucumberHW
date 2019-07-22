package insuranceTest.core;

import io.qameta.allure.Allure;

public class ReportHelper {

    public static void addTextAttach(String text) {
        Allure.addAttachment(text, "Кто молодец???)))");
    }

    public static void addTestDescription(String text) {
        Allure.addDescription(text);
    }

    public static void addHtmlDescription(String text) {
        Allure.addDescriptionHtml(text);
    }

}
