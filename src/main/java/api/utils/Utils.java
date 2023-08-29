package api.utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {

    public static Object getPropertyFromFile(String nameProperty) {
        Properties properties=new Properties();

       try (InputStream is=Files.newInputStream(Paths.get("src/test/api.properties"))) {

           properties.load(is);

       } catch (IOException e) {
           throw new RuntimeException(e);}

     return properties.getProperty(nameProperty);
    }
   public static <T> String toJson(T object){
        return new Gson().toJson(object);
   }
}

