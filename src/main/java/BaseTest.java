import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.sun.javafx.PlatformUtil;

public class BaseTest {
	WebDriver driver = new ChromeDriver();

	@BeforeSuite
	public void setDriverAndBrowserPath() {		
			
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    	driver.get("https://www.cleartrip.com/");
    	
    }
	
	@AfterSuite
	public void closeBrowser(){
		driver.quit();
	}
	
}
