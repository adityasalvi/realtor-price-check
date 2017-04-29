package PageFact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFact {
	
	/**

     * All WebElements are identified by @FindBy annotation

     */
	
	public  WebDriver driver;

    @FindBy(xpath="//*[@id='searchBox']")

    public WebElement searchBox;
    
    @FindBy(xpath="//*[@id='search-result-count']")
    
    public WebElement searchResultCount;
    
    //@FindBy(xpath="//*[@id='2']//a[contains(@href,'realestateandhomes')]")
    
    //@FindBy(xpath="//*[@id='2']//div[contains(@class,'srp-item-address')]")
    
    @FindBy(xpath="//*[@id='2']//*[@class='listing-street-address']")
    	
    public WebElement secondLinkAddress;
    
    @FindBy(xpath="//*[@id='2']//*[@class='data-price-display']")
    
    public WebElement searchResultPrice;
    
    @FindBy(xpath="//*[@id='ldp-pricewrap']//span[@itemprop='price']")
    
    public WebElement viewDetailsPrice;
    
    public PageFact(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    
}
