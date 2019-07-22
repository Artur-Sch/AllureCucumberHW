package insuranceTest.rgsPages;

import insuranceTest.annotations.ElementTitle;
import insuranceTest.annotations.PageTitle;
import insuranceTest.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@PageTitle("РГС страхование")
public class RgsMainPage extends BasePage {

    public final static String RGS_URL = "https://rgs.ru";

    @FindBy(xpath = "//*[@id='main-navbar-collapse']/ol[1]/li[2]")
    @ElementTitle("Страхование")
    private WebElement insuranceButton;

    @ElementTitle("ДМС")
    @FindBy(xpath = "//*[@id='rgs-main-menu-insurance-dropdown']//*[contains(text(), 'ДМС')]")
    private WebElement dmsButton;



}
