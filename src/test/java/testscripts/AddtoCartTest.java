package testscripts;

import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class AddtoCartTest extends BaseClass {

	@Test
	public void addtocartTest() {
		
		SoftAssert soft = new SoftAssert();
		
		home.clickgearstap();
		home.clickskillraraydemoapp();
		web.switchtochildbrowser();
		
		soft.assertTrue(demoapp.getpageheader().contains("ECommerce"));
		
		demoapp.mousehovertocourse(web);
		demoapp.clickseleniumtrainning();
		
		soft.assertEquals(selenium.getpagegeader(), "Selenium Training");
		
		int initialquantity = Integer.parseInt(selenium.getquantity());
		selenium.doubleclickplusbutton(web);
		int finalquantity = Integer.parseInt(selenium.getquantity());
		
		soft.assertEquals(finalquantity, initialquantity+1);
		
		selenium.clickaddtocart();
		web.handlealert("ok");
		soft.assertEquals(selenium.getitemaddmessage(), "Item added to cart");
		soft.assertAll();
	}
}
