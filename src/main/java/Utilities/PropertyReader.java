package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertyReader {

    private String propertyFileName = null;
    private Properties properties;


    public PropertyReader(String propertyFileName) {
        this.propertyFileName = propertyFileName;
    }


    private void readProperty() {

        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Environments" + File.separator + propertyFileName + ".properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public HashMap<String, String> getPropertyAsHashMap() {
        readProperty();
        HashMap<String, String> map = new HashMap<String, String>();

        for (Entry<Object, Object> entry : properties.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        return map;
    }
}
