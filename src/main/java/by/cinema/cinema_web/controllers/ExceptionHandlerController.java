package by.cinema.cinema_web.controllers;

import by.cinema.cinema_web.dto.responses.ErrorResponse;
import by.cinema.cinema_web.exceptions.FilmNotFoundException;
import by.cinema.cinema_web.exceptions.TicketNotFoundException;
import by.cinema.cinema_web.exceptions.UserNotFoundException;
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
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handUserNoFoundException(UserNotFoundException userNotFoundException) {
        log.warn(EXCEPTION_LOG_PATTERN, userNotFoundException.getClass(), LocalDateTime.now());
        return ErrorResponse.builder()
                .message(messageSource.getMessage((USER_NOT_FOUND_KEY),
                        new Object[]{userNotFoundException.getMessage(),
                                LocalDateTime.now()},
                        DEFAULT_EXCEPTION_MESSAGE,
                        LocaleContextHolder.getLocale()))
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FilmNotFoundException.class)
    public ErrorResponse handFilmNoFoundException(FilmNotFoundException filmNotFoundException) {
        log.warn(EXCEPTION_LOG_PATTERN, filmNotFoundException.getClass(), LocalDateTime.now());
        return ErrorResponse.builder()
                .message(messageSource.getMessage(FILM_NOT_FOUND_KEY,
                        new Object[]{filmNotFoundException.getMessage(),
                                LocalDateTime.now()},
                        DEFAULT_EXCEPTION_MESSAGE,
                        LocaleContextHolder.getLocale()))
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TicketNotFoundException.class)
    public ErrorResponse handEntityNoFoundException(TicketNotFoundException ticketNotFoundException) {
        log.warn(EXCEPTION_LOG_PATTERN, ticketNotFoundException.getClass(), LocalDateTime.now());
        return ErrorResponse.builder()
                .message(messageSource.getMessage(TICKET_NOT_FOUND_KEY,
                        new Object[]{ticketNotFoundException.getMessage(),
                                LocalDateTime.now()},
                        DEFAULT_EXCEPTION_MESSAGE,
                        LocaleContextHolder.getLocale()))
                .build();
    }
}