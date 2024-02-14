package by.cinema.cinema_web.exceptions;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FilmNotFoundException extends EntityNotFoundException {
    private String message;
}