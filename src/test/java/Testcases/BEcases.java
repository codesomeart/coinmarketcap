package Testcases;

import Configuration.EnvGlobals;
import Configuration.configProperties;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import General.ReusableMethods;

public class BEcases {

    @Test
    public static void getBitcoinId(){
        RestAssured.baseURI= configProperties.BaseURL;
        ReusableMethods.givenHeaders(ReusableMethods.headers("X-CMC_PRO_API_KEY", EnvGlobals.Token));
        ReusableMethods.whenFunction("get", configProperties.BaseURL + "/v1/cryptocurrency/map");
        ReusableMethods.thenFunction(200);
    }
}
