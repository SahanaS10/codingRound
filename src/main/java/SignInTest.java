import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

      MainPage mainPage = new MainPage(driver) ;
      mainPage.verifySignInError();
      
    }

   


}
