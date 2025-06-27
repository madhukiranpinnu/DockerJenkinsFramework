package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;


public class JsonUtil {
    private static final Logger log= LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper objmapper=new ObjectMapper();
    public static <T>T getData(String file,Class<T> type){
        try(InputStream stream=ResourceLoader.getResource(file)){
            return objmapper.readValue(stream,type);
        }
        catch (Exception e){
            log.error("unable to read test data {}", file, e);
        }
        return null;
    }
}
