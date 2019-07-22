package insuranceTest;


import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import insuranceTest.core.Init;
import insuranceTest.core.User;
import insuranceTest.sberPages.SberMainPage;
import insuranceTest.sberPages.SberTravelAndShoppingPage;
import insuranceTest.sberPages.SberTravelInsuracncePage;


public class SberScenario {

    SberMainPage sberMainPage = new SberMainPage();
    SberTravelAndShoppingPage sberTravelAndShoppingPage = new SberTravelAndShoppingPage();
    SberTravelInsuracncePage sberTravelInsuracncePage = new SberTravelInsuracncePage();
    User insuredUser = User.getRandomInsuredUserForSber();
    User insurantUser = User.getRandomInsurantUserForSber();


  static  {
        Init.setUp(SberMainPage.SBER_URL);
    }

    @When("Нажать на - \"(.+)\"$")
    public void clickInsured(String title) {
        sberMainPage.getElementByTitle(title).click();
    }

    @When("Выбрать – \"(.+)\"$")
    public void clickTravelAndShopping(String title) {
        sberMainPage.getElementByTitle(title).click();
    }

    @Then("Проверить на странице \"(.+)\" \"(.+)\" – \"(.+)\"$")
    public void checkTitle(String title, String element ,String textTo) {
        Init.setupPage(title);
        Init.getCurrentPage().checkErrorFromElement(Init.getCurrentPage().getElementByTitle(element),textTo);
    }

    @When("Нажать на – \"(.+)\"$")
    public void clickOpenForm(String title) {
        sberTravelAndShoppingPage.switchWindowByXpath(sberTravelAndShoppingPage.getElementByTitle(title));
    }


    @Then("На вкладке – Выбор полиса  выбрать сумму страховой защиты – \"(.+)\"$")
    public void clickMinimal(String title) {
        sberTravelInsuracncePage.getElementByTitle(title).click();
    }

    @When("Нажать кнопку - \"(.+)\"$")
    public void clickNext(String title) {
      sberTravelInsuracncePage.getElementByTitle(title).click();
    }

    @Then("На вкладке Оформить заполнить поля пользователя")
    public void fillForm() {
        sberTravelInsuracncePage.fillInTheFormInsuredUser(insuredUser);
        sberTravelInsuracncePage.fillInTheFormInsurantUser(insurantUser);
    }

    @When("Проверить, что все поля заполнены правильно, нажать - \"(.+)\"$")
    public void clickSave(String title) {
      sberTravelInsuracncePage.getElementByTitle(title).click();
    }

    @Then("Проверить, что появилось сообщение - \"(.+)\"$")
    public void checkError(String text) {
        sberTravelInsuracncePage.checkErrorFromElement(sberTravelInsuracncePage.getElementByTitle("Error"), text);
    }

    @After("@sber")
    public void down() {
        Init.tearDown();
    }
}
