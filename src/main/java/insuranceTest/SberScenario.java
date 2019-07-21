package insuranceTest;

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


   static {
        Init.setUp(SberMainPage.SBER_URL);
    }

    @When("Нажать на - \"(.+)\"$")
    public void clickInsured(String name) {
        sberMainPage.clickinsuranceButton(name);
    }

    @When("Выбрать – \"(.+)\"$")
    public void clickTravelAndShopping(String name) {
        sberMainPage.clickTravelAndShopping(name);
    }

    @Then("Проверить наличие на странице заголовка – \"(.+)\"$")
    public void checkTitle(String text) {
        sberTravelAndShoppingPage.checkTitle(text);
    }

    @When("Нажать на – \"(.+)\"$")
    public void clickOpenForm(String name) {
        sberTravelAndShoppingPage.openFormInsurance(name);
    }


    @Then("На вкладке – Выбор полиса  выбрать сумму страховой защиты – \"(.+)\"$")
    public void clickMinimal(String name) {
        sberTravelInsuracncePage.setMinimalClick(name);
    }

    @When("Нажать Оформить")
    public void clickNext() {
        sberTravelInsuracncePage.clickNext();
    }

    @Then("На вкладке Оформить заполнить поля пользователя")
    public void fillForm() {
        sberTravelInsuracncePage.fillInTheFormInsuredUser(insuredUser);
        sberTravelInsuracncePage.fillInTheFormInsurantUser(insurantUser);
    }

    @When("Проверить, что все поля заполнены правильно, нажать продолжить")
    public void clickSave() {
        sberTravelInsuracncePage.sendForm();
    }

    @Then("Проверить, что появилось сообщение - \"(.+)\"$")
    public void checkError(String text) {
        sberTravelInsuracncePage.checkMessage(text);
    }

}
