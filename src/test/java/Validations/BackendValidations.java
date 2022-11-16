package Validations;

import Configuration.EnvGlobals;
import General.ReusableMethods;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.List;

public class BackendValidations {
    public static List id;
    public static void validateCryptoInfo(String currencyId) {
        Assert.assertEquals("2015-08-07T00:00:00.000Z", ReusableMethods.getResponsePath("data." + EnvGlobals.ethereumId + ".date_added"));
        Assert.assertEquals("https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png", ReusableMethods.getResponsePath("data." + EnvGlobals.ethereumId + ".logo"));
        Assert.assertEquals("https://github.com/ethereum/wiki/wiki/White-Paper", ReusableMethods.getResponsePath("data." + EnvGlobals.ethereumId + ".urls.technical_doc[0]"));
        Assert.assertEquals("ETH", ReusableMethods.getResponsePath("data." + EnvGlobals.ethereumId + ".symbol"));
        JsonPath jsonPathEvaluator = EnvGlobals.response.jsonPath();
        id = jsonPathEvaluator.get("data.1027.tags");
        int actualCount = id.size();
        for (int i = 0; i < actualCount; i++) {
            if (currencyId.equals("1027")) {
                Assert.assertTrue(ReusableMethods.getResponsePath("data.1027.tags[" + i + "]").contains("Mineable"));
            }
        }
    }
}
