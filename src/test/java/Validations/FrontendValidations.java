package Validations;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.ArrayList;

public class FrontendValidations {
    static Long maxValue=10000000000L;
    static String priceText = String.valueOf(new ArrayList<String>());
    static String marketCapText = String.valueOf(new ArrayList<String>());
    static float price;
    static long marketCap;

    public static void validateRows(By locator){
        WebDriver driver = WebDriverFactory.getDriver();
        int sizeOfRows=driver.findElements(locator).size();
        Assert.assertEquals(100,sizeOfRows);
    }

    public static void validateFilters(By firstLocator,By secondLocator){
        WebDriver driver = WebDriverFactory.getDriver();
        int size=driver.findElements(firstLocator).size();
        for(int i=0;i<size;i++){
            priceText=(driver.findElements(firstLocator).get(i).getText().replaceAll("[$]",""));
            price=Float.parseFloat(priceText);
            marketCapText=(driver.findElements(secondLocator).get(i).getText().replaceAll("[$,]",""));
            marketCap=Long.parseLong(marketCapText);
            if ((price>=101.00&&price<=1000.00)&&(marketCap>=1000000000&&marketCap<=maxValue)){
                System.out.println("Passed");
            }
        }
    }
}
