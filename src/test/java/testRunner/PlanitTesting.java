package testRunner;

import org.testng.annotations.Test;

import pages.CartPage;

import org.testng.AssertJUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.CommonMethod;

public class PlanitTesting extends CommonMethod{
	
	int numFrog=2;
	int numBunny=5;
	int numBear=3;
	
	@Test(priority=1)
	public void verifyErrorMessage() {
		
		hp.contactBtn.click();
		cp.submitBtn.click();
		String actualText=cp.topAlertMsg.getText();
		String expectedText="We welcome your feedback - but we won't get it unless you complete the form correctly.";
		Assert.assertEquals(actualText, expectedText);
		
		//populate 
		cp.forename.sendKeys(randomFirstName());
		cp.email.sendKeys(randomEmail());
		cp.message.sendKeys(randomMsg());
		
		String actualText1=cp.topMSG.getText();
		String expectedText1="We welcome your feedback - tell it how it is.";
		Assert.assertEquals(actualText1, expectedText1);
		
		
	}
	
	@Test(priority=2,invocationCount = 5)
	public void verifySuccessfulSubmissionMsg() {
		
		hp.contactBtn.click();
		cp.forename.sendKeys(randomFirstName());
		cp.email.sendKeys(randomEmail());
		cp.message.sendKeys(randomMsg());
		cp.submitBtn.click();
		getWaitObject().until(ExpectedConditions.visibilityOf(cp.successAlertMsg));
		String actualText=cp.successAlertMsg.getText();
		String expectedText="we appreciate your feedback.";
		Assert.assertTrue(actualText.contains(expectedText));
		
	}
	@Test(priority=3)
	public void validateCartPage1() {
		hp.ShopBtn.click();
		hp.ShopBtn.click();
		sp.buyProduct("Stuffed Frog",numFrog);
		sp.buyProduct("Fluffy Bunny",numBunny);
		sp.buyProduct("Valentine Bear",numBear);
		hp.CartBtn.click();
		
		Assert.assertEquals(CtP.findItemPrice("Stuffed Frog"), 10.99);
		Assert.assertEquals(CtP.findItemPrice("Fluffy Bunny"), 9.99);
		Assert.assertEquals(CtP.findItemPrice("Valentine Bear"), 14.99);
		
		Assert.assertEquals(CtP.findItemQuantity("Stuffed Frog"), numFrog);
		Assert.assertEquals(CtP.findItemQuantity("Fluffy Bunny"), numBunny);
		Assert.assertEquals(CtP.findItemQuantity("Valentine Bear"), numBear);
		
		Assert.assertEquals(CtP.findItemSubTotal("Stuffed Frog"), CtP.findItemPrice("Stuffed Frog")*numFrog);
		Assert.assertEquals(CtP.findItemSubTotal("Fluffy Bunny"), CtP.findItemPrice("Fluffy Bunny")*numBunny);
		Assert.assertEquals(CtP.findItemSubTotal("Valentine Bear"), CtP.findItemPrice("Valentine Bear")*numBear);
		
		double subTotalSum=CtP.findItemSubTotal("Stuffed Frog")+CtP.findItemSubTotal("Fluffy Bunny")+CtP.findItemSubTotal("Valentine Bear");
		
		Assert.assertEquals(CtP.findTotalSum(),subTotalSum);
		
	}

}
