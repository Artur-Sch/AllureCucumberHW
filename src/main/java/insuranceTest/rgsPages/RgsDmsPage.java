package insuranceTest.rgsPages;

import insuranceTest.annotations.ElementTitle;
import insuranceTest.annotations.PageTitle;
import insuranceTest.core.BasePage;
import insuranceTest.core.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


@PageTitle("ДМС страхование")
public class RgsDmsPage extends BasePage {

    @ElementTitle("Title")
    @FindBy(xpath = "//*[contains(text(), 'добровольное медицинское страхование')]")
    private WebElement dmcTitle;

    @FindBy(xpath = "//*[@class='page-header']/*")
    public WebElement title;

    @ElementTitle("Отправить заявку")
    @FindBy(xpath = "//a[contains(text(),'Отправить заявку')]")
    private WebElement sendRequestButton;

    @ElementTitle("textRequest")
    @FindBy(xpath = "//*[contains(text(),'Заявка на добровольное медицинское страхование')]")
    private WebElement textRequest;

    @FindBy(xpath = "//*[@id='applicationForm']/div[2]/div[8]/textarea")
    private WebElement commentField;

    @FindBy(xpath = "//select[@name='Region']")
    private WebElement selectRegion;

    @FindBy(xpath = "//*[contains(text(),'Я согласен')]/preceding::input[@class='checkbox']")
    private WebElement checkbox;

    @ElementTitle("отправить")
    @FindBy(xpath = "//*[@id= 'button-m']")
    private WebElement sendButton;

    @ElementTitle("Эл. почта")
    @FindBy(xpath = "//*[contains(text(),'Эл. почта')]/following::span[contains(@class, 'validation')]")
    private WebElement emailValidation;


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
}
