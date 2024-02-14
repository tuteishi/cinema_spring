package by.cinema.cinema_web.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmResponse {
    private Long filmId;
    private String filmName;
    private LocalDateTime showDataTime;
}