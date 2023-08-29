package api.steps;

import api.config.BaseRequestSpecification;
import api.config.BaseResponseSpecification;
import api.config.Request;
import api.dto.UserBuilder;
import api.endpoints.Endpoints;
import io.restassured.response.ValidatableResponse;

import static api.utils.Utils.toJson;


public class UserSteps extends Request {
    BaseRequestSpecification request = new BaseRequestSpecification();
    BaseResponseSpecification response = new BaseResponseSpecification();
    private final UserBuilder user = UserBuilder.builder()
            .id(0)
            .username("nick")
            .build();

    public ValidatableResponse createUser() {
        return post(request.request(), toJson(user), Endpoints.CREATE_USER.getValue(), response.OK());
    }

    public ValidatableResponse createUser(UserBuilder body) {
        return post(request.request(), toJson(body), Endpoints.CREATE_USER.getValue(), response.OK());
    }

    public ValidatableResponse retrieveUser(String userName) {
        return get(request.request(), Endpoints.RETRIEVE_USER.getValue(), response.OK(), userName);
    }
}
