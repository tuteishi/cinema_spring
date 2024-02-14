package by.cinema.cinema_web.mappers;

import by.cinema.cinema_web.dto.requests.CreateApiUserRequest;
import by.cinema.cinema_web.dto.requests.CreateUserRequest;
import by.cinema.cinema_web.dto.responses.UserResponse;
import by.cinema.cinema_web.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userRequestToUser(CreateUserRequest userRequest);

    User userApiRequestToUser(CreateApiUserRequest createApiUserRequest);

    UserResponse userToUserResponse(User user);

    List<UserResponse> userListToUserResponseList(List<User> users);
}