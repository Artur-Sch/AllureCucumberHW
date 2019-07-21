package insuranceTest.rgsPages;

import insuranceTest.core.BasePage;
import insuranceTest.core.Init;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RgsMainPage extends BasePage {

//    public RgsMainPage() {
//        PageFactory.initElements(Init.getDriver(),this);
//    }

    public final static String RGS_URL = "https://rgs.ru";

    @FindBy(xpath = "//*[@id='main-navbar-collapse']/ol[1]/li[2]")
    private WebElement insuranceButton;

    @FindBy(xpath = "//*[@id='rgs-main-menu-insurance-dropdown']//*[contains(text(), 'ДМС')]")
    private WebElement dmsButton;

    @FindBy(xpath = "//ol[contains(@class,'rgs-menu pull-left')]")
    WebElement menuItems;

    @FindBy(xpath = "//div[contains(@class,'grid rgs-main-menu')]")
    WebElement menuInsurance;


    @Step("Выбрать пункт меню страхование")
    public void selectMenu() {
        waitForReadyElement(insuranceButton).click();
    }

    @Step("Open DMS Page")
    public void openDmsPage() {
        waitForReadyElement(dmsButton).click();
    }



}
