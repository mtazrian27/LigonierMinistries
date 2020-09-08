package framework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LigonierShopify extends BasePage {

    private By navHome = By.xpath("//*[@id=\"nav-home\"]/a/cufon/canvas");
    private By passwordTextField = By.id("pass");
    private By ligonierSearchBar = By.xpath("//*[@id=\"auto-search\"]");
    private By ligonierSearchButton = By.xpath("//*[@id=\"site-search-button\"]");
    private By devotionalFilter = By.xpath("//*[@id=\"search-refinements-type\"]/div/ul/li[1]/div/input");
    private By GodFilter = By.xpath("//*[@id=\"search-refinements-topics\"]/div/ul/li[6]/div/input");

    public void clickOnSearchBar(String text) {
        clickOn(ligonierSearchBar);
    }

    public void clickOnSearchButton() {
        clickOn(ligonierSearchButton);
    }

    public void typeOnSearchBar() {
        sendText(ligonierSearchBar,"Book");
    }

    public void clickOnDevotionaFilter() {
        clickOn(devotionalFilter);
    }

    public void clickOnGodFilter(){
        clickOn(GodFilter);
    }

    public void hitTheEnter() {
       hitEnter();
    }

//    public void ChristFilter(){
//        jsScrollToElement((WebElement) JesusChristFilter);
//    }

    public void wait3Seconds() throws InterruptedException {
        waitFor3Seconds();
    }
}
