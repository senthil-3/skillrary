package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebdriverUtility;

public class SeleniumTrainnig {

	/*
	 * this class contains elements locators and respective business libraries of selenum training  
	 */
	
//declaration
	@FindBy(xpath = "//h1[@class=\"page-header\"]")
	private WebElement pageheader;

	@FindBy(id = "quantity")
	private WebElement quantity;
	

	@FindBy(id = "add")
	private WebElement addbutton;
	

	@FindBy(xpath = "//button[.=\" Add to Cart\"]")
	private WebElement addtocartbutton;
	
	@FindBy(xpath ="//div[@class=\"callout callout-success\"]/span")
	private WebElement addedcartmessage;
	
//initialization
	public SeleniumTrainnig(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//utilization
	public String getpagegeader() {
		/*
		 * this method returns page header
		 */
		return pageheader.getText();
	}
	
	public String getquantity() {
		/*this method used to fetch the quantity of product
		 */
		return quantity.getAttribute("value");
	}
	
	public void doubleclickplusbutton(WebdriverUtility web) {
		/*
		 * this method is used to double click on add button
		 */
		web.doubleclick(addbutton);
	}
	
	public void clickaddtocart() {
		/*this method is used to click on add to cart button
		 */
		addtocartbutton.click();
	}
	
	public String getitemaddmessage() {
		/*this method is used to fetch item added message
		 */
	return addedcartmessage.getText();
	}
}
