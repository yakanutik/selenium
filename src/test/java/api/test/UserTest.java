package api.test;

import api.dto.UserBuilder;
import api.steps.UserSteps;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {

    @Test
    void verifyCreateAndRetrieveUser() {
        var payload = UserBuilder.builder().id(0).username("nick").build();

        var userSteps = new UserSteps();
        userSteps.createUser(payload);

        var expected = payload.getUsername();
        var actual = userSteps.retrieveUser(payload.getUsername()).extract().path("username");

        assertThat(actual)
                .as("Actual should be equal to expected")
                .isEqualTo(expected);
    }
}
