package insuranceTest;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import insuranceTest.core.Init;
import insuranceTest.core.User;
import insuranceTest.rgsPages.RgsDmsPage;
import insuranceTest.rgsPages.RgsMainPage;


public class RgsScenario {


    RgsMainPage rgsMainPage = new RgsMainPage();
    RgsDmsPage dmsPage = new RgsDmsPage();
    User rgsUser = User.getRandomUserForRgs();



   static  {
        Init.setUp(RgsMainPage.RGS_URL);
    }

    @When("^выбран пункт меню \"Страхование\"$")
    public void selectMenuItem() {
        rgsMainPage.selectMenu();
    }

    @When("^выбран вид страхования \"ДМС\"$")
    public void selectMenuInsurance() {
        rgsMainPage.openDmsPage();
    }

    @Then("^заголовок страницы содержит \"(.+)\"$")
    public void checkTitleDMSPage(String title) {
        dmsPage.checkTitle(title);
    }

    @When("^выполнено нажати на кнопку Отправить заявку$")
    public void clickBtnSendApp() {
        dmsPage.clickSendFormButton();
    }

    @Then("^проверить, что открылась страница , на которой присутствует текст - \"(.+)\"$")
    public void checkTitleSendAppPage(String textTo) {
        dmsPage.checkTextAvailability(textTo);

    }

    @When("^заполнятся поля формы данными случайного пользователя$")
    public void fillForm() {
        dmsPage.fillInTheForm(rgsUser);
    }

    @Then("^значения полей равны значениям пользователя нажимаем кнопку отправить$")
    public void checkFillForm() {
        dmsPage.sendForm();
    }

    @Then("^в поле \"(.+)\" присутствует сообщение об ошибке \"(.+)\"$")
    public void checkErrorMessage(String field, String errorMessage) {
        dmsPage.checkEmailError(field, errorMessage);

    }



}
