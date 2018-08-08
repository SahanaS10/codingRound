import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MainPage {
	WebDriver driver;
	
	
	public MainPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Locators
	
	@FindBy(id= "OneWay")
	private WebElement one_way_radio_button;
	
	@FindBy(id= "FromTag")
	private WebElement from_search_bar;
	
	@FindBy(id= "ToTag")
	private WebElement to_search_bar;
	
	@FindBy(id= "SearchBtn")
	private WebElement search_button;
	
	@FindBy(className ="searchSummary")
	private WebElement search_summary;
	
	@FindBy(xpath ="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	private WebElement date_picker;
	
	@FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    @FindBy(linkText = "Your trips")
    private WebElement your_trip;

    @FindBy(id = "SignIn")
    private WebElement signIn;
  
    @FindBy(xpath = "//iframe[@src='https://www.cleartrip.com/signin?popup=yes&service=/']")
	private WebElement nextFrame;
    
    @FindBy(id = "signInButton")
    private WebElement signInButton;
	
    @FindBy(id = "errors1")
    private WebElement error1;
    
	//Method
	public void verifySearchResult(String from, String to){
		one_way_radio_button.click();
		from_search_bar.clear();
		from_search_bar.sendKeys(from);
		chooseAutocomplete("ui-id-1");
		to_search_bar.clear();
		to_search_bar.sendKeys(to);
		chooseAutocomplete("ui-id-2");
		date_picker.click();
		search_button.click();
	    Assert.assertTrue(isElementPresent(By.className("searchSummary")));
	}
	
	public void verifyHotelBooking(String place, String people){
		hotelLink.click();
        localityTextBox.sendKeys(place);
        new Select(travellerSelection).selectByVisibleText(people);
        searchButton.click();
		
	}
	
	public void verifySignInError(){
		 your_trip.click();
	     signIn.click();
	     //Switching frame
	       driver.switchTo().frame(nextFrame);
	       signInButton.click();
	        String errors1 = error1.getText();
	        Assert.assertTrue(errors1.contains("There were errors in your submission"));
	        //Switching back to default frame
	        driver.switchTo().defaultContent();
	}
	public void chooseAutocomplete(String value){
		List<WebElement> options = driver.findElement(By.id(value)).findElements(By.tagName("li"));
        options.get(0).click();	
	}
	
	
	 private boolean isElementPresent(By by) {
	        try {
	            driver.findElement(by);
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }
	

}
