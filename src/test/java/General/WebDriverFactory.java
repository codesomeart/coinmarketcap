package General;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static Configuration.configProperties.Url;

public class WebDriverFactory {

    static WebDriver driver;

    public static WebDriver getInstance() throws MalformedURLException {
        finishDriver();
        WebDriverManager.chromedriver().setup();
        ChromeOptions op = new ChromeOptions();
        op.addArguments("--start-maximized");
        driver = new ChromeDriver(op);


        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }


    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        else
        {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }

    public static void finishDriver()
    {
        if (driver != null)
        {
            driver.quit();}
    }

}
