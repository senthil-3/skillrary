package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Skillraryhomepage {
	/*
	 * this class contains elements and respective business libraries of skillrary home page 
	 */
	
//declaration

	@FindBy(xpath="//img[@alt=\"SkillRary\"]")
	private WebElement logo;
	
	@FindBy(xpath="//ul[@class=\"home_menu list-unstyled list-inline\"]/li[1]")
	private WebElement langauageicon;

	@FindBy(xpath="//ul[@class=\"home_menu list-unstyled list-inline\"]/descendant::a[text()=' English ']")
	private WebElement english;
	
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearstab;
	
	@FindBy(xpath="//ul[@class=\"dropdown-menu gear_menu\"]/descendant::a[text()=' SkillRary Demo APP']")
	private WebElement skillraraydemoapp;	

//initialization
    public Skillraryhomepage(WebDriver driver){
    	PageFactory.initElements(driver, this);
    }
    
//utilization    
   public WebElement getlogo() {
	   /*
	    * this method returns logo
	    */
	    return logo;  
   }
   
   public void chooseenglish() {
	   /*
	    * this method is used to select englis as default language
	    */
	   langauageicon.click();
	   english.click();
   }
   
   public void clickgearstap() {
	   /*
	    * this method used to click on gears tab
	    */
	   gearstab.click();
   }
   
   public void clickskillraraydemoapp() {
	   /*
	    * this method is used to click on skillrarry demo app link
	    */
	   skillraraydemoapp.click();
   }
   
   

}