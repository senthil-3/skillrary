package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class AddPythonToMyCart extends BaseClass {
	
	@Test
	public void addPythonToMyCart() {
	SoftAssert soft = new SoftAssert();
	
	home.clickgearstap();
	home.clickskillraraydemoapp();
	web.switchtochildbrowser();
	
	soft.assertTrue(demoapp.getpageheader().contains("ECommerce"));
	
	demoapp.selectcatagory(web, 1);

	soft.assertEquals(testing.getpythoniamge(), "Testing");
	
	web.scrolltillelement(testing.getpythoniamge());
	web.draganddrop(testing.getpythoniamge(), testing.getcartarea());
	
	web.scrolltillelement(testing.getfacebookicon());
	testing.clickfacebook();
	
	soft.assertAll();
	}

}
