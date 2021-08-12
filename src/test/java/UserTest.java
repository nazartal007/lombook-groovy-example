import lombookModels.UserData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void singleUser(){
        Specs.request
                .when()
                .get("users/2")
                .then()
                .spec(Specs.response)
                .log().body();
    }

    @Test
    void allUsersPage2(){
        Specs.request
                .when()
                .get("users?page=2")
                .then()
                .spec(Specs.response)
                .log().body();
    }

    @Test
    void singleUserWithModelsLombook(){
        UserData data = Specs.request
                .when()
                .get("users/2")
                .then()
                .spec(Specs.response)
                .log().body()
                .extract().as(UserData.class);

        assertEquals(2,data.getData().getId());
    }
}

