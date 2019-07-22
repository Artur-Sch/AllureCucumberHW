package insuranceTest;


import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import insuranceTest.core.Init;
import insuranceTest.core.UserFactory;
import insuranceTest.sberPages.SberMainPage;
import insuranceTest.sberPages.SberTravelAndShoppingPage;
import insuranceTest.sberPages.SberTravelInsuracncePage;


public class SberScenario {

    SberMainPage sberMainPage = new SberMainPage();
    SberTravelAndShoppingPage sberTravelAndShoppingPage = new SberTravelAndShoppingPage();
    SberTravelInsuracncePage sberTravelInsuracncePage = new SberTravelInsuracncePage();




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

    @When("^Создать и сохранить пользователя \"(.+)\" с случайными данными$")
    public void createInsuredUser(String id) {
        UserFactory.getInstance().createUserSberInsured(id);
    }

    @When("^Создать пользоватля \"(.+)\" с случайными данными и сохранить$")
    public void createInsurantUser(String id) {
        UserFactory.getInstance().createUserSberInsurant(id);
    }
    @Then("На вкладке Оформить заполнить поля пользователя \"(.+)\" и \"(.+)\"$")
    public void fillForm(String firstId, String secondId) {
        sberTravelInsuracncePage.fillInTheFormInsuredUser(UserFactory.getInstance().getUser(firstId));
        sberTravelInsuracncePage.fillInTheFormInsurantUser(UserFactory.getInstance().getUser(secondId));
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
