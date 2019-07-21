package insuranceTest.rgsPages;

import insuranceTest.core.BasePage;
import insuranceTest.core.Init;
import insuranceTest.core.User;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class RgsDmsPage extends BasePage {

//    public RgsDmsPage() {
//        PageFactory.initElements(Init.getDriver(),this);
//    }

    @FindBy(xpath = "//*[contains(text(), 'добровольное медицинское страхование')]")
    private WebElement dmcTitle;

    @FindBy(xpath = "//*[@class='page-header']/*")
    public WebElement title;

    @FindBy(xpath = "//a[contains(text(),'Отправить заявку')]")
    private WebElement sendRequestButton;

    @FindBy(xpath = "//*[contains(text(),'Заявка на добровольное медицинское страхование')]")
    private WebElement textRequest;

    @FindBy(xpath = "//*[@id='applicationForm']/div[2]/div[8]/textarea")
    private WebElement commentField;

    @FindBy(xpath = "//select[@name='Region']")
    private WebElement selectRegion;

    @FindBy(xpath = "//*[contains(text(),'Я согласен')]/preceding::input[@class='checkbox']")
    private WebElement checkbox;

    @FindBy(xpath = "//*[@id= 'button-m']")
    private WebElement sendButton;

    @FindBy(xpath = "//*[contains(text(),'Эл. почта')]/following::span[contains(@class, 'validation')]")
    private WebElement emailValidation;

    @Step("check title - \"добровольное медицинское страхование\"")
    public void checkTitle(String text) {
        checkTextAvailabilityFromElement(dmcTitle, text);
    }

    @Step("click for button after waiting")
    public void clickSendFormButton() {
        waitForReadyElement(sendRequestButton).click();
    }

    @Step("check request text - \"Заявка на добровольное медицинское страхование\"")
    public void checkTextAvailability(String textTO) {
        checkTextAvailabilityFromElement(textRequest, textTO);
    }



    @Step("filling the form with user data {user}")
    public void fillInTheForm(User user) {
        fillInputByName("Фамилия", user.getLastName(), "");
        fillInputByName("Имя", user.getFirstName(), "");
        fillInputByName("Отчество", user.getPatronymic(), "");
        fillInputByName("Телефон", user.getTelephoneNumber(), "");
        fillInputByName("Эл. почта", user.getEmail(), "");

        commentField.sendKeys("здесь был Selenium");
        checkErrorWithAttribute(commentField, "здесь был Selenium");

        new Select(selectRegion).selectByValue("77");
        checkErrorWithAttribute(selectRegion, "77");
        checkbox.click();

    }

    @Step("click button send")
    public void sendForm() {
        waitForReadyElement(sendButton).click();
    }

    @Step("check e-mail error")
    public void checkEmailError(String field, String errorMessage) {
        String xpath = "//*[text()='"+field+"']/..//*[@class='validation-error']";
        String actualValue =Init.getDriver().findElement(By.xpath(xpath)).getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage), actualValue.contains(errorMessage));
        takeScreenshot();
    }



}
