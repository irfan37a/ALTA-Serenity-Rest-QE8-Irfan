package starter.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ListUserStepDeff {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with page {string}")
    public void getListUserWithPageString(String string) {
        reqresAPI.getListUsersString(string);

    }

    @Given("Get list user with id {int}")
    public void getListUserWithId(int id) {
        reqresAPI.getListSingleUsers(id);
    }

    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Validate json schema list user")
    public void validateJsonSchemaListUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/ListUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
