import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest extends BaseTest{

    @Test
    public void shouldBeAbleToSearchForHotels() {
    	MainPage mainPage = new MainPage(driver);
    	mainPage.verifyHotelBooking("Indiranagar, Bangalore", "1 room, 2 adults");
    }


}
