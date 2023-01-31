package testRunner;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.CommonMethod;

public class PlanitTesting extends CommonMethod{
	
	
	@Test
	public static void verifyErrorMessage() {
		
		hp.contactBtn.click();
		cp.submitBtn.click();
		String actualText=cp.topAlertMsg.getText();
		String expectedText="We welcome your feedback - but we won't get it unless you complete the form correctly.";
		AssertJUnit.assertEquals(actualText, expectedText);
		
		//populate 
		cp.forename.sendKeys(randomFirstName());
		cp.email.sendKeys(randomEmail());
		cp.message.sendKeys(randomMsg());
		
		String actualText1=cp.topMSG.getText();
		String expectedText1="We welcome your feedback - tell it how it is.";
		AssertJUnit.assertEquals(actualText1, expectedText1);
		
		
	}
	
	@Test(invocationCount = 5)
	public static void verifySuccessfulSubmissionMsg() {
		
		hp.contactBtn.click();
		cp.forename.sendKeys(randomFirstName());
		cp.email.sendKeys(randomEmail());
		cp.message.sendKeys(randomMsg());
		cp.submitBtn.click();
		getWaitObject().until(ExpectedConditions.visibilityOf(cp.successAlertMsg));
		String actualText=cp.successAlertMsg.getText();
		String expectedText="we appreciate your feedback.";
		AssertJUnit.assertTrue(actualText.contains(expectedText));
		
	}
	
	@Test
	public static void validateCartPage() {
		
		hp.ShopBtn.click();
		sp.buyProduct("Stuffed Frog",2);
		sp.buyProduct("Fluffy Bunny",5);
		sp.buyProduct("Valentine Bear",3);
		System.out.println("added info");
		hp.CartBtn.click();
		
		
	}
	

}
