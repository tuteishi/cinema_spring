package by.cinema.cinema_web.controllers;

import by.cinema.cinema_web.dto.responses.ErrorResponse;
import by.cinema.cinema_web.exceptions.FilmNotFoundException;
import by.cinema.cinema_web.exceptions.TicketNotFoundException;
import by.cinema.cinema_web.exceptions.UserNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static by.cinema.cinema_web.utils.Constants.*;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {

    private final MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse handEntityNoFoundException(EntityNotFoundException entityNotFoundException) {
        log.warn("EXCEPTION: {} | {} ", entityNotFoundException.getClass(), LocalDateTime.now());
        return ErrorResponse.builder()
                .message(messageSource.getMessage(getKey(entityNotFoundException),
                        new Object[]{entityNotFoundException.getMessage(),
                                LocalDateTime.now()},
                        "Entity not found.",
                        LocaleContextHolder.getLocale()))
                .build();
    }

    private String getKey(EntityNotFoundException entityNotFoundException) {
        if (entityNotFoundException instanceof UserNotFoundException) {
            return USER_NOT_FOUND_KEY;
        } else if (entityNotFoundException instanceof FilmNotFoundException) {
            return FILM_NOT_FOUND_KEY;
        } else if (entityNotFoundException instanceof TicketNotFoundException) {
            return TICKET_NOT_FOUND_KEY;
        }
        return NOT_FOUND_TYPE_EXCEPTION_MESSAGE;
    }
}