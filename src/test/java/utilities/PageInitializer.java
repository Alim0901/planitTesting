package utilities;

import pages.CartPage;
import pages.ContactPage;
import pages.HomePage;
import pages.ShopPage;

public class PageInitializer extends BaseClass {

	public static HomePage hp;
	public static ContactPage cp;
	public static ShopPage sp;
	public static CartPage CtP;
	
public static void initialize() {
		
		hp = new HomePage();
		cp=new ContactPage();
		sp=new ShopPage();		
		CtP=new CartPage();
		
	}

}
