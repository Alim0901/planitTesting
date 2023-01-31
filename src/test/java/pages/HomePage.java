package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class HomePage {
	
	public HomePage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(xpath="//*[@id='nav-contact']/a")
	public WebElement contactBtn;
	
	@FindBy(id="nav-shop")
	public WebElement ShopBtn;
	
	@FindBy(id="nav-cart")
	public WebElement CartBtn;
	
	
}
