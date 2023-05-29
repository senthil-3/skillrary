package genericlibraries;

import java.io.File;

import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverUtility {

	private WebDriver driver;
	/*
	 * this method use to launch browser
	 */
	public WebDriver luanchbrowser(String browser) {
	/*
	 * this class contains all reusable methods of webdriver
	 */
		switch (browser) {
		case "chormedriver":
			WebDriverManager.chromedriver().setup();
			return driver = new ChromeDriver();
			
		
		case "firefoxdriver":
			WebDriverManager.firefoxdriver().setup();
			return driver = new FirefoxDriver();
			
			
		case "edgedriver":
			WebDriverManager.edgedriver().setup();
			return driver = new EdgeDriver ();
			
		default:
			System.out.println("enter invalid browser");
			break;
		}
		return driver;
	}
	public void maximizebrowser() {
		/*
		 * this method use to maximixe the browser
		 */
		driver.manage().window().maximize();
	}
	
	public void navigatetoapplication(String url){
		/*
		 * this method id used to navigate to an app via url
		 */
		driver.get(url);
	}
	public void waituntilelementfound(long time) {
		/*
		 * this method waits until element/elements is found
		 */
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public WebElement Expelicitwait(long time, WebElement element) {
		/*
		 * this method used untile element is displeyed
		 */
		WebDriverWait wait = new WebDriverWait(driver, time);
			return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement Expelicitwait(WebElement element, long time) {
		/*
		 * this method used untile element is enabled
		 */
		WebDriverWait wait = new WebDriverWait(driver, time);
			return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean explicitwait(long time, String element) {
		/*
		 * this method used untile webpage titile is displayed
		 */
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.titleContains(element));
	}
	
	public void mousehover(WebElement element) {
		/*
		 * this method is used to mousehover to an element
		 */
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	

	public void doubleclick(WebElement element) {
		/*
		 * this method is used to doubleclick to an element
		 */
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	

	public void rightclick(WebElement element) {
		/*
		 * this method is used to rightclick to an element
		 */
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	

	public void draganddrop(WebElement element, WebElement target) {
		/*
		 * this method is used to drag and drop to an element
		 */
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, target).perform();
	}
	
	public void dropdown(WebElement element, int index) {
		/*
		 * this method is used select an element from dropedown using selectbyindex
		 */
		Select s =new Select(element);
		s.selectByIndex(index);
	}
		
	public void dropdown(String value, WebElement element) {
		/*
		 * this method is used select an element from dropedown using selectby value
		 */
		Select s =new Select(element);
		s.selectByValue(value);
	}
	
	public void dropdown(WebElement element, String text) {
		/*
		 * this method is used select an element from dropedown using selectByVisibleText
		 */
		Select s =new Select(element);
		s.selectByVisibleText(text);
	}
	 
	public void scrolltillelement(Object element) {
		/*
		 * this method is used scroll till the element 
		 */
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	public void switchtoframe(int index) {
		/*
		 * this method is used to swietch to frame using index
		 */
		driver.switchTo().frame(index);	
	}
	
	public void switchtoframe(String idorname) {
		/*
		 * this method is used to swietch to frame using id or name attribute value
		 */
		driver.switchTo().frame(idorname);
	}
	
	public void switchtoframe(WebElement frameElement) {
		/*
		 * this method is used to swietch to frame using frame Element
		 */
		driver.switchTo().frame(frameElement);	
	}
	
	public void switchbackfromframe() {
		/*
		 * this method is used to swietch back from frame
		 */
		driver.switchTo().defaultContent();
	}
	
	public void takescreenshot(JavaUtility jUtil){
		
		/*
		 * this method is used to captur the screenshot of window
		 */
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshot/ss_"+jUtil.getcurrenttime()+".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void handlealert(String status) {
		/*
		 * this method is used to handle alert
		 */
		Alert al = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok")) 
			al.accept();
		else 
			al.dismiss();
	}
	
	public void switchtochildbrowser() {
		/*
		 * this method is used to switch to child browser
		 */
		Set<String> set = driver.getWindowHandles();
		for(String id :set) {
			driver.switchTo().window(id);
		}
	}
	
	public void closecurrentwindow() {
		/*
		 * this method is used to close the current window
		 */
		driver.close();
	}
	
	public void quitallwindows() {
		/*
		 * this method is used to exit the all window
		 */
		driver.quit();
	}
	
}
