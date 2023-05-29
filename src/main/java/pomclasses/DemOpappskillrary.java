package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebdriverUtility;

public class DemOpappskillrary {
	/*
	 * this class contains elements and respective business libraries of skillrary demo app page 
	 */
	
//declaration
	
	@FindBy(xpath="//a[@class=\"navbar-brand\"]")
	private WebElement pageheader;
	
	@FindBy(id="course")
	private WebElement course;
	
	@FindBy(xpath="//span/a[text()=\"Selenium Training\"]")
	private WebElement Seleniumtraining;
	
	@FindBy(name="addresstype")
	private WebElement catagoryid;
	
	@FindBy(xpath="//a[text()=\"Contact Us\"]")
	private WebElement contactuslink; 
	
//initialization
	public DemOpappskillrary(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
//utilization
	
	public String getpageheader() {
		/*
		 * this method returns page header text 
		 */
		return pageheader.getText();
	}
	
	public void mousehovertocourse(WebdriverUtility web) {
		/*
		 * this method is used to mouse hover to course tab
		 */
		web.mousehover(course);
	}
	
	public void clickseleniumtrainning() {
		/*
		 * this method used to click on selenium training 
		 */
		Seleniumtraining.click();
	}
	
	public void selectcatagory(WebdriverUtility web, int index) {
		/*
		 * this method is used to select catagory
		 */
		web.dropdown(catagoryid, index);
	}
	
	public WebElement getcontactuslink() {
		/*
		 * 
		 * this method returns contact us link
		 */
		return contactuslink ;
	}
	
	public void clickoncontactuslink() {
		/*
		 * this method is used to click on contact us link
		 */
		contactuslink.click();
	}
}
