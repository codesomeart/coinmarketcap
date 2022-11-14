package Configuration;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath({"ApplicationConfig.properties"})
public class ApplicationConfigReader {
    @Property("BaseURL")
    private String BaseURL;

    @Property("APIKey")
    private String APIKey;

    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }

    public String getBaseURL(){return BaseURL; }
    public String getAPIKey(){return APIKey; }


}
