package by.cinema.cinema_web.utils;

import java.math.BigDecimal;

public class Constants {

    public static final String EXCEPTION_LOG_PATTERN = "EXCEPTION: {} | {} ";
    public static final String DEFAULT_EXCEPTION_MESSAGE = "Entity not found.";

    public static final BigDecimal TICKET_COAST = new BigDecimal("15.0");

    public static final String USER_NOT_FOUND_KEY = "user.missing.message";
    public static final String FILM_NOT_FOUND_KEY = "film.missing.message";
    public static final String TICKET_NOT_FOUND_KEY = "ticket.missing.message";

    public static final String BASE_NAME = "classpath:message";
    public static final String DEFAULT_ENCODING = "UTF-8";

    public static final String LOG_REQUEST_PATTERN = "HTTP Method - {} | Controller Method - {} | URL - {}";
    public static final String LOG_RESPONSE_PATTERN = "HTTP Method - {} | Controller Method - {} | URL - {} | Response - {}";

}