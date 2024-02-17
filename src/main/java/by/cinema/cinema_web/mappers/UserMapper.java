package by.cinema.cinema_web.mappers;

import by.cinema.cinema_web.dto.requests.UserRequest;
import by.cinema.cinema_web.dto.responses.UserResponse;
import by.cinema.cinema_web.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapUserRequestToUser(UserRequest userRequest);

    UserResponse mapUserToUserResponse(User user);

    List<UserResponse> mapUserListToUserResponseList(List<User> users);
}