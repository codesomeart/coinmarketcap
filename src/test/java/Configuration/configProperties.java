package Configuration;

public class configProperties {
    public static ApplicationConfigReader appConfig = new ApplicationConfigReader();

    public static String BaseURL = appConfig.getBaseURL();
    public static String APIKey = appConfig.getAPIKey();

}
