package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static Properties properties;

    public ConfigLoader() {
        // Initialize the Properties object
        properties = new Properties();

        // Load the properties file
        try {
            FileInputStream fis = new FileInputStream("//src//test//java//Properties//userdata.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the value associated with the key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    //Load the propetries file from the folder
//    public static Properties userdata;
//
//    static {
//        try {
//            userdata = LoadProperties("D:\\Automation\\Automation projects\\WebApplication\\Qyoud\\QyoudProject\\src\\test\\java\\Properties\\userdata.properties");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    //System.getProperty("user.dir")+
//
//
//
//    private  static  Properties LoadProperties(String path) throws FileNotFoundException {
//      Properties pro= new Properties();
//      //stream for reading file
//    try {
//        FileInputStream stream = new FileInputStream(path);
//    } catch (FileNotFoundException e)
//    {
//        System.out.println("Error Occured"+e.getMessage());
//    }catch (IOException e)
//    {
//        System.out.println("Error Occured"+e.getMessage());
//    }
//    return pro;
//  }
}

