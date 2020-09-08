package framework;

//import com.sun.tools.javac.comp.Enter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;
import static stepdefinition.SharedSD.getDriver;

/**
 * Created by lorik on 2/7/18.
 */
public class BasePage {

	private Driver driver;
	private final String TEXT_XPATH = "//*[text()='";

	public void clickOn(By locator) {
		try {
			getDriver().findElement(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

		public void hitEnter() {
			try {
				Actions actions = new Actions(getDriver());
				actions.sendKeys(ENTER);
			} catch (NoSuchElementException e) {
				Assert.fail("Element is not found with this locator: ");
				e.printStackTrace();
			}

	}

	public void sendText(By locator, String text) {
		try {
			getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public String getTextFromElement(By locator) {
		String text = null;
		try {
			text = getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}

	public static void mouseOver(By locator)  {
		WebElement element = getDriver().findElement(locator);

		Actions action = new Actions(getDriver());
		action.moveToElement(element).build().perform();
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	/**
	 * This method can be used to click on element with exact text as input text.
	 * avoid using this if you think the element text is not unique
	 *
	 * @param text - text of the element.
	 */
	public void clickOnExactText(String text) {
		try {
			returnElementWithExactText(text).click();
		} catch (StaleElementReferenceException s) {
			returnElementWithExactText(text).click();
		} catch (WebDriverException we) {
			Actions actions = new Actions(getDriver());
			actions.click( returnElementWithExactText(text));
		}
	}

	/**
	 * Method will return web element with exact text for any tag
	 *
	 * @param text - text of the element.
	 * @return
	 */
	private WebElement returnElementWithExactText(String text) {
		return getDriver().findElement(By.xpath(TEXT_XPATH + text + "']"));

	}

	public void clickOnBrowserBackArrow() {
		getDriver().navigate().back();
	}

	public void waitFor3Seconds() throws InterruptedException {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnBrowserForwardArrow() {
		getDriver().navigate().forward();
	}

	public void refreshBrowser() {
		getDriver().navigate().refresh();
	}

	public void jsScrollToElement(WebElement element) {
		String mouseOverScript = "arguments[0].scrollIntoView(false);";
		try {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript(mouseOverScript, element);
		} catch (Exception e) {
		}
	}
//	public void waitFor3Seconds() throws InterruptedException {
//		Thread.sleep(3000);
//	}
}
