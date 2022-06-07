package in.co.gorest.userinfo;

import in.co.gorest.testbase.TestBase;
import in.co.gorest.usersinfo.UsersSteps;
import in.co.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserInfoCRUDTest extends TestBase {
    static String name = "Tenali Ramakrishnaveni"+ TestUtils.getRandomValue();
    static String gender = "female";
    static String email = "tenalii.ramakrishna1@gmail.com"+TestUtils.getRandomValue();
    static String status = "active";
    static int id;


    @Steps
    UsersSteps usersSteps;

    @Title("Getting All The List Of Users")
    @Test
    public void test001(){
        usersSteps.getListOfUsers().statusCode(200);

    }

    @Title("Creating A New User")
    @Test
    public void test002(){
        ValidatableResponse response = usersSteps.createUser(name,gender,email,status);
        response.log().all().statusCode(201);
    }

    @Title("Updating The List Of Users")
    @Test
    public void test003(){
        name = name +"_updated";
        ValidatableResponse response = usersSteps.createUser(name,gender,email,status);
        response.log().all().statusCode(200);

    }

    @Title("Deleting The  User")
    @Test
    public void test004(){
        usersSteps.deleteUserById(id).statusCode(404);


    }


}
