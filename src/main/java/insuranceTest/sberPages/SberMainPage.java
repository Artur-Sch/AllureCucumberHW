package insuranceTest.sberPages;

import insuranceTest.core.BasePage;
import insuranceTest.core.Init;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SberMainPage extends BasePage {
    public final static String SBER_URL = "http://www.sberbank.ru/ru/person";

    @FindBy(xpath = "//*[@aria-label='Меню Страхование']/span")
    private WebElement insuranceButtonQ;

    @FindBy(xpath = "//*[@id='submenu-5']//*[contains(text(), 'Путешествия и покупки')]")
    private WebElement travelAndShoppingButton;


//    @Step("Open openSberTravelAndShoppingPage")
//    public SberTravelAndShoppingPage openSberTravelAndShoppingPage() {
//        waitForReadyElement(insuranceButton).click();
//        waitForReadyElement(travelAndShoppingButton).click();
//        return new SberTravelAndShoppingPage();
//    }

    @Step("Нажать на страхование")
    public void clickinsuranceButton(String name) {
        String xpath = "//*[@aria-label='" + name + "']/span";
        waitForReadyElement(Init.getDriver().findElement(By.xpath(xpath))).click();
//        waitForReadyElement(insuranceButtonQ);
    }

    @Step("Нажать на Путешествия и покупки")
    public void clickTravelAndShopping(String name) {
        String xpath = "//*[@id='submenu-5']//*[contains(text(), '"+name+"')]";
        waitForReadyElement(Init.getDriver().findElement(By.xpath(xpath))).click();
    }
}
