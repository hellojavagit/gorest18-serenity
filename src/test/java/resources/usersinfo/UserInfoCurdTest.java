package resources.usersinfo;

import in.co.gorest.testbase.TestBase;
import in.co.gorest.usersinfo.UsersSteps;
import in.co.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class UserInfoCurdTest extends TestBase {

    static String name = "Tenali Ramakrishnaveni"+ TestUtils.getRandomValue();
    static String gender = "female";
    static String email = "tenalii.ramakrishna1@gmail.com"+TestUtils.getRandomValue();
    static String status = "active";
    static int id;

    UsersSteps userssteps;

    @Title("Getting All The List Of Users")
    @Test
    public void test001(){
        userssteps.getListOfUsers().statusCode(200);

    }

    @Title("Creating A New User")
    @Test
    public void test002(){
        ValidatableResponse response = userssteps.createUser(name,gender,email,status);
        response.log().all().statusCode(201);
    }

    @Title("Getting All The List Of Users")
    @Test
    public void test003(){
        name = name +"_updated";
        ValidatableResponse response = userssteps.createUser(name,gender,email,status);
        HashMap<?,?> userMap= response.log().all().extract().path("");
        Assert.assertThat(userMap,hasValue(name));

    }

    @Title("Getting All The List Of Users")
    @Test
    public void test004(){
        userssteps.deleteUserById(id).statusCode(204);


    }


}
