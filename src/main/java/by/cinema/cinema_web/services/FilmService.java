package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.FilmRequest;
import by.cinema.cinema_web.dto.responses.FilmResponse;

import java.util.List;

public interface FilmService {
    FilmResponse createFilm(FilmRequest filmRequest);

    FilmResponse getFilmById(Long filmId);

    List<FilmResponse> getFilms();

    FilmResponse updateFilm(FilmRequest filmRequest, Long filmId);

    void deleteFilm(Long filmId);
}