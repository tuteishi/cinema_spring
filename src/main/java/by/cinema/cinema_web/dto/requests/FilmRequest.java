package by.cinema.cinema_web.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmRequest {

    @NotBlank
    private String filmName;

    @NotNull
    @Future
    @JsonDeserialize
    private LocalDateTime showDataTime;
}