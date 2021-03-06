package in.co.gorest.testbase;


import in.co.gorest.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

import static in.co.gorest.constants.Path.USERS;

/**
 * Created by Jay
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        //RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
        RestAssured.basePath = USERS;
    }

}
