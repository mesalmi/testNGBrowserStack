import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    private static WebDriver driver;
    public static final String USERNAME = "ziedmesalmi1";
    public static final String AUTOMATE_KEY = "8bjLzCiSbAPpdtbUv8ay";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
    }

    @Test(dataProvider = "Authentication")
    public void test(String sUsername, String sPassword) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "7");
        WebDriver driver=null;
        driver = new RemoteWebDriver(new URL(URL), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.store.demoqa.com");
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        driver.findElement(By.id("log")).sendKeys(sUsername);
        driver.findElement(By.id("pwd")).sendKeys(sPassword);
        driver.findElement(By.id("login")).click();
        driver.quit();

    }

}