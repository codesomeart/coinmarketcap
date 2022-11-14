package stepdefs;

import Configuration.Endpoints;
import Configuration.EnvGlobals;
import Configuration.configProperties;
import General.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.internal.com.google.gson.JsonArray;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.List;

public class BEstepdefs {

    public static List id;
    @Given("user enters API key")
    public void user_enters_api_key() {
        RestAssured.baseURI= configProperties.BaseURL;
        ReusableMethods.givenHeaders(ReusableMethods.headers("X-CMC_PRO_API_KEY", configProperties.APIKey));
    }

    @And("user hits API")
    public void user_hits_API(){
        ReusableMethods.whenFunction("get", configProperties.BaseURL + Endpoints.cryptoMap);
    }

    @Then("user gets the response")
    public void user_gets_the_response(){
        ReusableMethods.thenFunction(200);
        EnvGlobals.bitcoinId=ReusableMethods.getResponsePath("data[0].id");
        System.out.println("Bitcoin id is: " + EnvGlobals.bitcoinId);
        EnvGlobals.USDTid=ReusableMethods.getResponsePath("data[115].id");
        System.out.println("USDT id is: " + EnvGlobals.USDTid);
        JsonPath jsonPathEvaluator = EnvGlobals.response.jsonPath();
        id = jsonPathEvaluator.get("data");
        int ActualCount1 = id.size();
        for (int i = 0 ;i<ActualCount1;i++){
            if (ReusableMethods.getResponsePath("data["+i+"].name").equals("Ethereum")){
                System.out.println("Index is: " + i);
                EnvGlobals.USDTid=ReusableMethods.getResponsePath("data["+i+"].id");
                System.out.println("USDT id is: " + EnvGlobals.USDTid);
                break;
            }
        }
    }
}
