package General;

import Configuration.EnvGlobals;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class ReusableMethods {

    public static RequestSpecification REQUEST;

    public static void contentType(String contentType) {
        REQUEST = RestAssured.given().contentType(contentType);
        EnvGlobals.requestSpecification = REQUEST.given();
    }

    public static void givenHeaders(Map<String, String> headers) {
        contentType("application/json");
        EnvGlobals.requestSpecification = REQUEST.given().headers(headers);
    }

    public static void whenFunction(String requestType, String endPoint) {
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
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().post(endPoint, new Object[0]);
                break;
            case 1:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().get(endPoint);
                break;
            case 2:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().delete(endPoint, new Object[0]);
                break;
            case 3:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().put(endPoint, new Object[0]);
                break;
            case 4:
                EnvGlobals.response = EnvGlobals.requestSpecification.when().log().all().patch(endPoint, new Object[0]);
        }

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

}
