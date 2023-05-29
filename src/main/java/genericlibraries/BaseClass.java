package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomclasses.Contactuspage;
import pomclasses.DemOpappskillrary;
import pomclasses.SeleniumTrainnig;
import pomclasses.Skillraryhomepage;
import pomclasses.Testingpage;



public class BaseClass {

	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility java;
	protected WebdriverUtility web;
	protected WebDriver driver;
	
	
	protected Skillraryhomepage home;
	protected DemOpappskillrary demoapp;
	protected SeleniumTrainnig selenium;
	protected Testingpage testing;
	protected Contactuspage contact;
	
	
	//@Beforesuite
	//@BeforeTest
	@BeforeClass
	public void classConfig() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		java = new JavaUtility();
		web = new WebdriverUtility();
		
		property.propertiesUnit(IConstantPath.PROPERTIES_PATH);
		excel.excelunit(IConstantPath.EXCEL_PATH);
	}
	
	@BeforeMethod
	public void methodconfifuration() {
		driver = web.luanchbrowser("chormedriver");
		web.maximizebrowser();
		web.navigatetoapplication(property.readdatafrompropertiesfile("url"));
		web.waituntilelementfound(Long.parseLong(property.readdatafrompropertiesfile("time")));
		
		home = new Skillraryhomepage(driver);
		demoapp = new DemOpappskillrary(driver);
		selenium = new SeleniumTrainnig(driver);
		testing = new Testingpage(driver);
		contact = new Contactuspage(driver);
		
		home.chooseenglish();
	}
	
	@AfterMethod 
	public void methodteardown() {
		web.quitallwindows();
	}
	@AfterClass
	public void classteardown() {
		excel.closeExcel();
	}
	//@AfterTest
	//@AfterSuite
	
	
	
}
