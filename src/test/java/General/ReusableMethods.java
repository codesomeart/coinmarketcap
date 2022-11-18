package General;

import Configuration.EnvGlobals;
import Configuration.configProperties;
import com.mysql.cj.exceptions.AssertionFailedException;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReusableMethods {

    public static List id;
    public static RequestSpecification REQUEST;

    public static void contentType(String contentType) {
        REQUEST = RestAssured.given().contentType(contentType);
        EnvGlobals.requestSpecification = REQUEST.given();
    }

    public static void givenHeaders(Map<String, String> headers) {
        contentType("application/json");
        EnvGlobals.requestSpecification = REQUEST.given().headers(headers);
    }

    public static void whenFunctionWithParams(String requestType, String endPoint,String queryParamName, String queryParamValue) {
        byte var3 = -1;
        switch(requestType.hashCode()) {
            case -1335458389:
                if (requestType.equals("delete")) {
                    var3 = 2;
                }
                break;
            case 102230:
                if (requestType.equals("get")) {
                    var3 = 1;
                }
                break;
            case 111375:
                if (requestType.equals("put")) {
                    var3 = 3;
                }
                break;
            case 3446944:
                if (requestType.equals("post")) {
                    var3 = 0;
                }
                break;
            case 106438728:
                if (requestType.equals("patch")) {
                    var3 = 4;
                }
        }

        switch(var3) {
            case 0:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParam(queryParamName,queryParamValue).post(endPoint);
                break;
            case 1:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParam(queryParamName,queryParamValue).get(endPoint);
                break;
            case 2:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParam(queryParamName,queryParamValue).delete(endPoint);
                break;
            case 3:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParam(queryParamName,queryParamValue).put(endPoint);
                break;
            case 4:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParam(queryParamName,queryParamValue).patch(endPoint);
        }

    }

    public static void whenFunctionWithListOfParams(String requestType, String endPoint,String queryParam) {
        String str="1,2,3,4,5,6,7,8,9,10";
        byte var3 = -1;
        switch(requestType.hashCode()) {
            case -1335458389:
                if (requestType.equals("delete")) {
                    var3 = 2;
                }
                break;
            case 102230:
                if (requestType.equals("get")) {
                    var3 = 1;
                }
                break;
            case 111375:
                if (requestType.equals("put")) {
                    var3 = 3;
                }
                break;
            case 3446944:
                if (requestType.equals("post")) {
                    var3 = 0;
                }
                break;
            case 106438728:
                if (requestType.equals("patch")) {
                    var3 = 4;
                }
        }

        switch(var3) {
            case 0:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParams(queryParam,str).post(endPoint);
                break;
            case 1:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParams(queryParam,str).get(endPoint);
                break;
            case 2:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParams(queryParam,str).delete(endPoint);
                break;
            case 3:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParams(queryParam,str).put(endPoint);
                break;
            case 4:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParams(queryParam,str).patch(endPoint);
        }

    }


    public static String getResponsePath(String key) {
        return EnvGlobals.response.getBody().path(key, new String[0]) == null ? "" : EnvGlobals.response.getBody().path(key, new String[0]).toString();
    }

    public static void thenFunction(int statusCode) {
        EnvGlobals.response.then().log().all().statusCode(statusCode);
    }

    public static <K, V> Map<K, V> headers(Object... keyValues) {
        Map<K, V> map = new HashMap();

        for(int index = 0; index < keyValues.length / 2; ++index) {
            map.put((K) keyValues[index * 2], (V) keyValues[index * 2 + 1]);
        }

        return map;
    }

    public static void currencyConversion(String endPoint,String amount,String sourceCurrency){
        if (sourceCurrency.equals("BTC")){
            EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParam("amount",amount).queryParam("convert", configProperties.conversionCurrency).queryParam("id",EnvGlobals.bitcoinId).get(endPoint);
        }
        else if (sourceCurrency.equals("USDT")){
            EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParam("amount",amount).queryParam("convert",configProperties.conversionCurrency).queryParam("id",EnvGlobals.USDTid).get(endPoint);
        }
        else if (sourceCurrency.equals("ETH")){
            EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParam("amount",amount).queryParam("convert",configProperties.conversionCurrency).queryParam("id",EnvGlobals.ethereumId).get(endPoint);
        }
    }

    public static void currencyMapping(String endPoint){
        String[] str={"USDT","BTC","ETH"};
        EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().queryParams("symbol",str[0]+"," +str[1]+","+str[2]).get(endPoint);

    }

    public static String fetchParticularIds(String nameOfCurrency){
        JsonPath jsonPathEvaluator = EnvGlobals.response.jsonPath();
        id = jsonPathEvaluator.get("data");
        int actualCount = id.size();
        for (int i = 0 ;i<actualCount;i++){
            if (ReusableMethods.getResponsePath("data["+i+"].name").equals(nameOfCurrency)){
                EnvGlobals.cryptoId=ReusableMethods.getResponsePath("data["+i+"].id");
                break;
            }
        }
        return EnvGlobals.cryptoId;
    }

    public static void fetchIds(){
        Map<String, String> id;
        JsonPath jsonPathEvaluator = EnvGlobals.response.jsonPath();
        id=jsonPathEvaluator.get("data");
        EnvGlobals.actualDataCount = id.size();
        for (int i = 1 ;i<=EnvGlobals.actualDataCount;i++){
            System.out.println(ReusableMethods.getResponsePath("data." + i + ".id"));
        }
    }

    public static void arriveToWebsite(){
        try {
            General.WebDriverFactory.getInstance();
        } catch (Exception exception) {
            throw new RuntimeException();
        }
    }

    public static void ClickingOn(By locator) {
        try {

            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);

            wait.until(ExpectedConditions.elementToBeClickable(locator));
            {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                {
                    wait.until(ExpectedConditions.elementToBeClickable(locator));
                    {
                        WebElement link =  WebDriverFactory.getDriver().findElement(locator);
                        link.click();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scrollToSpecificHeight(){
        WebDriver driver = WebDriverFactory.getDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
    }


    public static void IhaveGivenInput(By Locator, String textboxvalue) {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
            {
                WebElement input = WebDriverFactory.getDriver().findElement(Locator);
                Thread.sleep(1000);
                input.clear();
                input.sendKeys(textboxvalue);
            }
        } catch (ElementNotVisibleException e)
        {
            throw new AssertionFailedException(String.format("The element provided {0} is not on screen", Locator));
        }
        catch (StaleElementReferenceException e)
        {
            throw new AssertionFailedException(String.format("The element provided {0} is Stale", Locator));
        }
        catch (InvalidElementStateException e)
        {
            throw new AssertionFailedException(String.format("The element provided {0} is not in desired state", Locator));
        }
        catch (Exception e)
        {
            throw new AssertionFailedException(String.format("The element provided {0} is invalid", Locator));
        }
    }

    @AfterTest
    public static void quitDriver(){
        WebDriver driver = WebDriverFactory.getDriver();
        driver.close();
        driver.quit();
    }

}
