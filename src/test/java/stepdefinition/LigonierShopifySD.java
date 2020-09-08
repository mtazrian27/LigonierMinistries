package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LigonierShopifySD {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private BasePage basePage = new BasePage();
    private LigonierShopify ligonierShopify = new LigonierShopify();

//    @Given("^I am on home page$")
//    public void iAmOnHomePage() {
//        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Facebook - Log In or Sign Up", "Invalid Home Page");
//    }

    @When("^I click on\"([^\"]*)\"$")
    public void i_click_on_text(String text) {
        ligonierShopify.clickOnSearchBar(text);
    }

    @And("^I type on Search bar$")
    public void i_enter_text_on_search_bar() {
        ligonierShopify.typeOnSearchBar();
        }

    @And("^I click on search button$")
    public void i_click_on_button() {
        ligonierShopify.clickOnSearchButton();
    }

    @And("^I click on devotional filter$")
    public void devotional_filter () {
        ligonierShopify.clickOnDevotionaFilter();
    }

    @And("^I click on God filter$")
    public void God_filter () {
        ligonierShopify.clickOnGodFilter();
    }

    @And("^I scroll to Christ filter$")
    public void Scroll_Christ_filter (WebElement element) {
        ligonierShopify.jsScrollToElement(element);
    }

    @And("^I hit enter$")
    public void i_hit_enter() {
        ligonierShopify.hitEnter();
    }

    @And("^I wait for 3 seconds$")
        public void i_wait_for_3_seconds() throws InterruptedException {
       basePage.waitFor3Seconds();
    }

//
//    @Then("^I verify that i am an invalid login page$")
//    public void verifyInvalidLoginPage() {
//        Assert.assertEquals(loginPage.getPageHeader(), "Log into Facebook");
//    }
//
//    @Then("^I see number [0-9] in text field$")
//    public void textField(int num) {
//
//    }
//
//    @Then("^I verify invalid signup error message$")
//    public void verifySignUpErrorMessage() {
//        Assert.assertEquals(homePage.getErrorMessage(), "Invalid signup");
//    }
    }
