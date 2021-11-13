import org.testng.annotations.Test;
import static helpers.Constants.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LanguageQueryTest {

    @Test
    public void shouldReturnStatus200andAllRequiredFields(){
        given().
                header(HEADER_CONTENT_TYPE, HEADER_APPLICATION).
                log().all().
                body(BODY_LANGUAGE_SUCCESSFUL).
                when().
                post(BASE_URL).
        then().
                log().all().
                assertThat().
                statusCode(200).
                assertThat().body("data.language.name", equalTo("Portuguese")).
                assertThat().body("data.language.native", equalTo("Português")).
                assertThat().body("data.language.rtl", equalTo(false));
    }

    @Test
    public void shouldReturnStatus200andRTLFieldNotNull(){
        given().
                header(HEADER_CONTENT_TYPE, HEADER_APPLICATION).
                log().all().
                body(BODY_LANGUAGE_SUCCESSFUL).
        when().
                post(BASE_URL).
        then().
                log().all().
                assertThat().
                assertThat().body("data.language.rtl", notNullValue());
    }

    @Test
    public void shouldReturnStatus400IncorrectFieldReturned(){
        given().
                header(HEADER_CONTENT_TYPE, HEADER_APPLICATION).
                log().all().
                body(BODY_LANGUAGE_INCORRECT_ATTRIBUTE_NAME).
                when().
                post(BASE_URL).
        then().
                log().all().
                assertThat().
                statusCode(400).
                assertThat().body(containsString(ERROR_MESSAGE));
    }
}
