package insuranceTest.sberPages;

import insuranceTest.core.BasePage;
import insuranceTest.core.Init;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SberTravelAndShoppingPage extends BasePage {

    @FindBy(xpath = "//h3[contains(text(),'Страхование путешественников')]")
    private WebElement travelInsuranceTitle;

//    @FindBy(xpath = "//*[@data-pid='SBRF-TEXT-2247407']//a[contains(text(), 'Оформить онлайн')]")
    private WebElement makeOnlineButton;

    @Step("check title to contains - \"Страхование путешественников\"")
    public void checkTitle(String text) {
        checkTextAvailabilityFromElement(travelInsuranceTitle, text);
    }
//
//    @Step(" open SberTravelInsuracncePage")
//    public SberTravelInsuracncePage openFormInsurance() {
//        waitForReadyElement(makeOnlineButton);
//        switchWindowByXpath(makeOnlineButton);
//        return new SberTravelInsuracncePage();
//    }

    @Step("click open form")
    public void openFormInsurance(String name) {
        String xpath = "//*[@data-pid='SBRF-TEXT-2247407']//a[contains(text(), '"+name+"')]";
        WebElement makeOnlineButton = Init.getDriver().findElement(By.xpath(xpath));
        waitForReadyElement(makeOnlineButton);
        switchWindowByXpath(makeOnlineButton);
    }


}
