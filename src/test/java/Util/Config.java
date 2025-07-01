package Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;
public class Config {

    private static final Logger log= LoggerFactory.getLogger(Config.class);
    private static final String propertiesLocation="config/default.properties";
    private static Properties properties;
    private static Properties loadProp(){
        properties = new Properties();
        try(InputStream inputStream=ResourceLoader.getResource(propertiesLocation))
        {
            properties.load(inputStream);
        }
        catch (Exception e){
            log.error("Property file is not loaded: {} ",propertiesLocation);
        }
        return properties;
    }
    public static void initializeProperties(){
        properties=loadProp();
        for(String key:properties.stringPropertyNames()){
            if(System.getProperties().containsKey(key)){
                properties.setProperty(key,System.getProperty(key));
            }
        }
        log.info("Proprties are loaded");
        log.info("------------------------------------------------------");
        for(String key:properties.stringPropertyNames()){
            log.info("values are {} : {}",key,properties.getProperty(key));
        }
        log.info("------------------------------------------------------");
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
