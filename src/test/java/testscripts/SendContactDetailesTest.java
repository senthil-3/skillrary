package testscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class SendContactDetailesTest extends BaseClass {
	
	@Test
	public void sendContactDetailesTest() {
		SoftAssert soft =new SoftAssert();
		
		home.clickgearstap();
		home.clickskillraraydemoapp();
		web.switchtochildbrowser();
		
		soft.assertTrue(demoapp.getpageheader().contains("ECommerce"));
		
		web.scrolltillelement(demoapp.getcontactuslink());
		demoapp.clickoncontactuslink();
		
		soft.assertTrue(contact.getcontacruslogo().isDisplayed());
		
		Map <String,String> map =excel.getdatafromexcel("Sheet1");
		contact.senddetails(map.get("fullname"), map.get("email"), map.get("subject"), map.get("message"));
		
		soft.assertAll();	
	}
}
