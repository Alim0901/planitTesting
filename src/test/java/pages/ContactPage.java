package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class ContactPage {
	public ContactPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
  }
	
	@FindBy(xpath="//*[@class='btn-contact btn btn-primary']")
	public WebElement submitBtn;
	
	@FindBy(xpath="//*[@class='alert alert-error ng-scope']")
	public WebElement topAlertMsg;
	
	@FindBy(xpath="//*[@class='alert alert-info ng-scope']")
	public WebElement topMSG;
	
	@FindBy(id="forename")
	public WebElement forename;
	
	@FindBy(id="surname")
	public WebElement surname;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="telephone")
	public WebElement telephone;
	
	@FindBy(id="message")
	public WebElement message;
	
	@FindBy(xpath="//*[@class='alert alert-success']")
	public WebElement successAlertMsg;
	
	
	
}
