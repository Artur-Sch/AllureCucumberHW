package insuranceTest.sberPages;

import insuranceTest.annotations.ElementTitle;
import insuranceTest.annotations.PageTitle;
import insuranceTest.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageTitle("Путешествия и покупки")
public class SberTravelAndShoppingPage extends BasePage {

    @ElementTitle("заголовок")
    @FindBy(xpath = "//h3[contains(text(),'Страхование путешественников')]")
    private WebElement travelInsuranceTitle;

    @ElementTitle("Оформить онлайн")
    @FindBy(xpath = "//*[@data-pid='SBRF-TEXT-2247407']//a[contains(text(), 'Оформить онлайн')]")
    WebElement makeOnlineButton;

}
