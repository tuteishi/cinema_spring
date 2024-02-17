package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.FilmRequest;
import by.cinema.cinema_web.dto.responses.FilmResponse;

import java.util.List;

public interface FilmService {
    /** Making a film. */
    FilmResponse createFilm(FilmRequest filmRequest);

    /** Getting a film by id. */
    FilmResponse getFilmById(Long filmId);

    /** Getting all films. */
    List<FilmResponse> getFilms();

    /** Film update. */
    FilmResponse updateFilm(FilmRequest filmRequest, Long filmId);

    /** Delete  film. */
    void deleteFilm(Long filmId);
}