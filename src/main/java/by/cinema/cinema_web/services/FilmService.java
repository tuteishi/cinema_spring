package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.CreateFilmRequest;
import by.cinema.cinema_web.dto.responses.FilmResponse;

import java.util.List;

public interface FilmService {
    FilmResponse creatFilm(CreateFilmRequest filmRequest);

    FilmResponse getFilmById(Long filmId);

    List<FilmResponse> getAllFilms();

    FilmResponse updateFilm(CreateFilmRequest filmRequest, Long filmId);

    void deleteFilm(Long filmId);
}