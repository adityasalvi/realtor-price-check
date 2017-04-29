package stepDefinition;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import GenericFunctions.GenericFunc;
import PageFact.PageFact;
import cucumber.annotation.en.Given; 
import cucumber.annotation.en.Then; 
import cucumber.annotation.en.When; 

/**
*
* @author Aditya Salvi
* @description Realtor.com Assignment
* 
*/
public class DriverScript {
	
	public static WebDriver driver;	
	private static PageFact objFactory;
	private static WebDriverWait wait;
	private static Actions builder;
	private static String firefoxDriverPath = "./geckodriver.exe";
	
	private long searchResultsCount = 0;
	private long searchPagePrice = 0;
	private long detailsPagePrice = 0;
	
   
   @Given("^I have navigated to to \"([^\"]*)\" website using \"([^\"]*)\" browser$")
   public void I_have_navigated_to_to_website_using_browser(String arg1, String arg2) {
	   
	   if(arg2.equals("Chrome"))
	   		driver = new ChromeDriver(); // Initializing Chrome Driver
	   else
	   {
		   System.setProperty("webdriver.gecko.driver", firefoxDriverPath); // Initializing Firefox Driver
		   driver = new FirefoxDriver();
	   }
		    
	   	driver.get("http://"+arg1+"/"); 
	   	
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver,10);
		
		objFactory = new PageFact(driver); //Initializing Object Factory
		
		builder = new Actions(driver); //Initializing Actions driver
   }

   @When("^Realtor.com Site is opened enter \"([^\"]*)\" in search Box$")
   public void Realtor_com_Site_is_opened_enter_in_search_Box(String arg1) {
	   
	   wait.until(ExpectedConditions.visibilityOf(objFactory.searchBox));
	   		   	
	   GenericFunc.enterText(objFactory.searchBox, arg1);
	   	
	   GenericFunc.pressKeys(objFactory.searchBox, "ENTER");
		
   }

   @When("^SearchPage is Open VERIFY the search results are greater than zero$")
   public void SearchPage_is_Open_VERIFY_the_search_results_are_greater_than_zero() {

	   wait.until(ExpectedConditions.visibilityOf(objFactory.searchResultCount));	
	   
	   searchResultsCount = Integer.parseInt(GenericFunc.getTextFromElement(objFactory.searchResultCount).replaceAll("[A-Za-z ]", ""));
	   
	   assertTrue(searchResultsCount > 0);
	   
   }

   @Then("^Get the price and Click on the address of second search results$")
   public void Get_the_price_and_Click_on_the_address_of_second_search_results() {

	   searchPagePrice = Long.parseLong(GenericFunc.getTextFromElement(objFactory.searchResultPrice).replaceAll("[$, ]", ""));

	   builder
       .moveToElement(objFactory.secondLinkAddress).click().perform();
		   
   }
   
   @Then("^Get the price and Click on the address of second search results for Firefox browser$")
   public void Get_the_price_and_Click_on_the_address_of_second_search_results_for_Firefox_browser() {
	   
	   searchPagePrice = Long.parseLong(GenericFunc.getTextFromElement(objFactory.searchResultPrice).replaceAll("[$, ]", ""));

	   GenericFunc.clickElement(objFactory.secondLinkAddress);
	   
   }

   @When("^Details page is opened VERIFY the price on details page is SAME as search results page$")
   public void Details_page_is_opened_VERIFY_the_price_on_details_page_is_SAME_as_search_results_page() {

	   wait.until(ExpectedConditions.visibilityOf(objFactory.viewDetailsPrice));
	   
	   detailsPagePrice = Long.parseLong(GenericFunc.getTextFromElement(objFactory.viewDetailsPrice).replaceAll("[$, ]", ""));
	   
	   assertEquals(searchPagePrice, detailsPagePrice);
	   
   }

   @Then("^Browser is Closed$")
   public void Browser_is_Closed() {

	   driver.quit();
   }

}
