package utilities;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class CommonMethod extends PageInitializer {

	public static void hoverOver(WebElement element) {
		Actions act = new Actions(getDriver());
		act.moveToElement(element).build().perform();	}	

	
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Constants.explicit_wait_time);
		return wait;
	}

	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static Faker faker = new Faker();

	public static String randomFirstName() {

		return faker.name().firstName();
	}

	public static String randomLastName() {

		return faker.name().lastName();
	}

	public static String randomEmail() {
		return faker.internet().emailAddress();
		
	}
	
	public static String randomMsg() {
		
		return faker.lorem().word();
		
	}

	public static void sendKey(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void click(WebElement element) {
		waitForClickability(element).click();
	}

	public static void wait(double second) {
		try {
			Thread.sleep((int) (second * 1000));
		} catch (Exception e) {

		}

	}

	public static void getTittle() {
		driver.getTitle();
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static String getText(WebElement webelement) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();  
		String text = (String) js.executeScript("return arguments[0].value", webelement);
		return text;	}

}
