package stepdefs;

import Configuration.EnvGlobals;
import Configuration.configProperties;
import General.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;

public class BEstepdefs {

    @Given("user enters API key")
    public void user_enters_api_key() {
        RestAssured.baseURI= configProperties.BaseURL;
        ReusableMethods.givenHeaders(ReusableMethods.headers("X-CMC_PRO_API_KEY", EnvGlobals.Token));
    }

    @And("user hits API")
    public void user_hits_API(){
        ReusableMethods.whenFunction("get", configProperties.BaseURL + "/v1/cryptocurrency/map");
    }

    @Then("user gets the response")
    public void user_gets_the_response(){
        ReusableMethods.thenFunction(200);
    }
}
