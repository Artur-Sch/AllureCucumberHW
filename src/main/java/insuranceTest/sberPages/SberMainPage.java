package insuranceTest.sberPages;

import insuranceTest.annotations.ElementTitle;
import insuranceTest.annotations.PageTitle;
import insuranceTest.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageTitle("Сбербанк главная")
public class SberMainPage extends BasePage {
    public final static String SBER_URL = "http://www.sberbank.ru/ru/person";

    @ElementTitle("Меню Страхование")
    @FindBy(xpath = "//*[@aria-label='Меню Страхование']/span")
    private WebElement insuranceButtonQ;

    @ElementTitle("Путешествия и покупки")
    @FindBy(xpath = "//*[@id='submenu-5']//*[contains(text(), 'Путешествия и покупки')]")
    private WebElement travelAndShoppingButton;
}
