package starter.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Register user with valid json")
    public void registerUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/RegisterUser.json");
        reqresAPI.postRegisterUser(json);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

//    @And("Response body email should be {string} and password {string}")
//    public void responseBodyEnailShouldBeAndPassword(String name, String job) {
//        SerenityRest.then()
//                .body(ReqresResponses.EMAIL, equalTo(name))
//                .body(ReqresResponses.PASSWORD, equalTo(job));
//    }

    @And("Validate json schema register user")
    public void validateJsonSchemaRegisterUser() {
        File jsonSchema = new File(Constant.JSON_REQUEST+"/RegisterUser.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
