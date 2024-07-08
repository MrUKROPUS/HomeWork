import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    private RequestSpecification createRequest(String contentType, String body) {
        return given()
                .header("Content-Type", contentType)
                .body(body);
    }

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .log().all();
    }

    @Test
    public void testPostRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        createRequest("text/plain", requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .log().all();
    }

    @Test
    public void testPostFormData() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .log().all();
    }

    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        createRequest("text/plain", requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .log().all();
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        createRequest("text/plain", requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .log().all();
    }

    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        createRequest("text/plain", requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .log().all();
    }
}