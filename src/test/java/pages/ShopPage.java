package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethod;

public class ShopPage {

	public ShopPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);	}
	
	@FindBy(xpath="//*[@class='product-title ng-binding']")
	public  List<WebElement> productNameList;
	
	@FindBy(xpath="//*[@class='btn btn-success']")
    public List<WebElement> BuyBtnList;
	
	@FindBy(xpath="//*[@class='product-price ng-binding']")
	public List<WebElement> PriceList;
	
	
	public  void buyProduct(String productName, int productQuantity) {
		
		for (int i=0;i<BuyBtnList.size();i++) {

			if(productNameList.get(i).getText().contains(productName)) {
				for(int j=0; j<productQuantity; j++) {
					
					BuyBtnList.get(i).click();
					
				}
			}
		}
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
}
