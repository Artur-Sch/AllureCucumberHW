package insuranceTest;



import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import insuranceTest.core.Init;
import insuranceTest.core.User;
import insuranceTest.rgsPages.RgsDmsPage;
import insuranceTest.rgsPages.RgsMainPage;


public class RgsScenario {


    RgsMainPage rgsMainPage = new RgsMainPage();
    RgsDmsPage dmsPage = new RgsDmsPage();
    User saveUser = User.getRandomUserForRgs();

   static  {
        Init.setUp(RgsMainPage.RGS_URL);
    }

    @When("^выбрать пункт меню \"(.+)\"$")
    public void selectMenuItem(String fieldTitle) {
       rgsMainPage.getElementByTitle(fieldTitle).click();
    }

    @When("^выбрать вид страхования \"(.+)\"$")
    public void selectMenuInsurance(String fieldTitle) {
        rgsMainPage.getElementByTitle(fieldTitle).click();
    }

    @Then("^заголовок страницы \"(.+)\" содержит \"(.+)\"$")
    public void checkTitleDMSPage(String title, String textTo) {
        Init.setupPage(title);
        Init.getCurrentPage().checkErrorFromElement(Init.getCurrentPage().getElementByTitle("Title"),textTo);
    }

    @When("^нажать на кнопку  - \"(.+)\"$")
    public void clickBtnSendApp(String fieldTitle) {
        dmsPage.getElementByTitle(fieldTitle).click();
    }

    @Then("^проверить, что открылась страница , на которой присутствует текст - \"(.+)\"$")
    public void checkTitleSendAppPage(String textTo) {
        dmsPage.checkErrorFromElement(dmsPage.getElementByTitle("textRequest"), textTo);
    }

    @When("^заполнить поля формы данными сгенерированного случайного пользователя")
    public void fillForm() {
        dmsPage.fillInTheForm(saveUser);
    }

    @Then("^проверить значения полей и значений пользователя, нажать кнопку \"(.+)\"$")
    public void checkFillForm(String fieldTitle) {
        dmsPage.getElementByTitle(fieldTitle).click();
    }

    @Then("^в поле \"(.+)\" присутствует сообщение об ошибке \"(.+)\"$")
    public void checkErrorMessage(String field, String errorMessage) {
        dmsPage.checkErrorFromElement(dmsPage.getElementByTitle(field), errorMessage);
    }

    @After("@rgs")
    public void down() {
        Init.tearDown();
    }

}
