package Configuration;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath({"ApplicationConfig.properties"})
public class ApplicationConfigReader {
    @Property("BaseURL")
    private String BaseURL;

    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }

    public String getBaseURL(){return BaseURL; }

}
