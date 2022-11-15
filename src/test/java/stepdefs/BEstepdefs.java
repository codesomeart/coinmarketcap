package stepdefs;

import Configuration.Endpoints;
import Configuration.EnvGlobals;
import Configuration.configProperties;
import General.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class BEstepdefs {

    @Given("user enters API key")
    public void user_enters_api_key() {
        RestAssured.baseURI= configProperties.BaseURL;
        ReusableMethods.givenHeaders(ReusableMethods.headers("X-CMC_PRO_API_KEY", configProperties.APIKey));
    }

    @And("user hits currency mapping API")
    public void user_hits_currency_mapping_API(){
        ReusableMethods.currencyMapping(configProperties.BaseURL + Endpoints.cryptoMap);
    }

    @When("user validates status code")
    public void user_validates_status_code(){
        ReusableMethods.thenFunction(200);
    }

    @And("user gets the response")
    public void user_gets_the_response(){
        EnvGlobals.bitcoinId=ReusableMethods.fetchIds("Bitcoin");
        System.out.println("Bitcoin id is: " + EnvGlobals.bitcoinId);
        EnvGlobals.USDTid=ReusableMethods.fetchIds("Tether");
        System.out.println("USDT id is: " + EnvGlobals.USDTid);
        EnvGlobals.ethereumId=ReusableMethods.fetchIds("Ethereum");
        System.out.println("Ethereum id is: " + EnvGlobals.ethereumId);
    }

    @Then("^user converts currency \"([^\"]*)\" into BOB$")
    public void user_converts_currency(String sourceCurrency){
        RestAssured.baseURI= configProperties.BaseURL;
        ReusableMethods.givenHeaders(ReusableMethods.headers("X-CMC_PRO_API_KEY", configProperties.APIKey));
        ReusableMethods.currencyConversion(configProperties.BaseURL + Endpoints.conversionTool,configProperties.conversionAmount,sourceCurrency);
    }
}
