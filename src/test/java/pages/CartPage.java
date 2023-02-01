package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CreateNumbersOnlyStr;

public class CartPage {

	public CartPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath="//*[@class='total ng-binding']")
	public WebElement totalPrice;
	
	
	public static double findItemPrice(String productName) {
		
		return Double.parseDouble(BaseClass.getDriver().findElement(By.xpath("//td[contains(.,'"+productName+"')]/..//td[2]")).getText().replaceAll("[^\\d.]", ""));
		
	}
	
	
	public static int findItemQuantity(String productName) {
		
		return Integer.parseInt(BaseClass.getDriver().findElement(By.xpath("//td[contains(.,'"+productName+"')]/..//td[3]//input")).getAttribute("value"));
		
	}

	public static double findItemSubTotal(String productName) {
		
		return Double.parseDouble(BaseClass.getDriver().findElement(By.xpath("//td[contains(.,'"+productName+"')]/..//td[4]")).getText().replaceAll("[^\\d.]", ""));
		
	}
	
	public  double findTotalSum() {
      return Double.parseDouble(totalPrice.getText().replaceAll("[^\\d.]", ""));
	}
	
}
