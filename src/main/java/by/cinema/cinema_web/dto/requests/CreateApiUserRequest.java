package by.cinema.cinema_web.dto.requests;

import by.cinema.cinema_web.entities.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateApiUserRequest {
    @NotNull
    @Positive
    private Integer age;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotNull
    private UserRole userRole;
}
