package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

public class ReqresAPI {
//    public static String BASE_URL = "https://reqres.in";
//    public static final String DIR = System.getProperty("user.dir");
//    public static String JSON_REQUEST = DIR+"/src/test/resources/JSON/Request";
//    public static String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";

    public static String GET_LIST_USER = Constant.BASE_URL+"/api/users?page={page}";
    public static String GET_SINGLE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";

    public static String POST_REGISTER_USER = Constant.BASE_URL+"/api/register";

    @Step("Get List User")
    public void getListUsers(int page){

        SerenityRest.given().pathParam(ReqresResponses.PAGE, page);
    }
    @Step("Get List Single User")
    public void getListSingleUsers(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get List User")
    public void getListUsersString(String pageString){
        SerenityRest.given().pathParam(ReqresResponses.PAGE, pageString);
    }
    @Step("Post create user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post register user")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id,File json ){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam(ReqresResponses.ID, id);
    }

}
