
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class testngParameters {
    private static WebDriver driver;
    public static final String USERNAME = "ziedmesalmi1";
    public static final String AUTOMATE_KEY = "8bjLzCiSbAPpdtbUv8ay";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    //@Parameters({ "sUsername", "sPassword" })
    public void test(/*String sUsername, String sPassword*/) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "7");
        WebDriver driver=null;
        driver = new RemoteWebDriver(new URL(URL), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.store.demoqa.com");
        try {
            driver.findElement(By.xpath(".//*[@id='account']/a")).click();
            driver.findElement(By.id("log")).sendKeys("sasom");
            driver.findElement(By.id("pwd")).sendKeys("ajsdkajsd");
            driver.findElement(By.id("login")).click();
            Thread.sleep(2000);
            driver.quit();
        }catch (Exception e){
            driver.quit();
        }
    }

}