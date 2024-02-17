package by.cinema.cinema_web.controllers;

import by.cinema.cinema_web.dto.requests.UserRequest;
import by.cinema.cinema_web.dto.responses.UserResponse;
import by.cinema.cinema_web.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody @Valid UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(@PathVariable @NotNull Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers() {
        return userService.getUsers();
    }

    @PatchMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updateUser(@RequestBody @Valid UserRequest userRequest,
                                   @PathVariable @NotNull Long id) {
        return userService.updateUser(userRequest, id);
    }

    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable @NotNull Long id) {
        userService.deleteUser(id);
    }
}