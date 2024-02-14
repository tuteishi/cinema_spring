package by.cinema.cinema_web.controllers;

import by.cinema.cinema_web.dto.requests.CreateFilmRequest;
import by.cinema.cinema_web.dto.responses.FilmResponse;
import by.cinema.cinema_web.services.FilmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class FilmController {

    private final FilmService filmService;

    @PostMapping("film")
    @ResponseStatus(HttpStatus.CREATED)
    public FilmResponse createFilm(@RequestBody @Valid CreateFilmRequest filmRequest) {
        return filmService.creatFilm(filmRequest);
    }

    @GetMapping("film/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FilmResponse getFilmById(@PathVariable Long id) {
        return filmService.getFilmById(id);
    }

    @GetMapping("allFilms")
    @ResponseStatus(HttpStatus.OK)
    public List<FilmResponse> getAllFilms() {
        return filmService.getAllFilms();
    }

    @PostMapping("film/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FilmResponse updateFilm(@RequestBody @Valid CreateFilmRequest filmRequest,
                                   @PathVariable Long id) {
        return filmService.updateFilm(filmRequest, id);
    }

    @DeleteMapping("film/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
    }
}