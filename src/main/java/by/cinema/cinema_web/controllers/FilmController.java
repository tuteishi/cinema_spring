package by.cinema.cinema_web.controllers;

import by.cinema.cinema_web.dto.requests.FilmRequest;
import by.cinema.cinema_web.dto.responses.FilmResponse;
import by.cinema.cinema_web.services.FilmService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    public FilmResponse createFilm(@RequestBody @Valid FilmRequest filmRequest) {
        return filmService.createFilm(filmRequest);
    }

    @GetMapping("film/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FilmResponse getFilmById(@PathVariable @NotNull Long id) {
        return filmService.getFilmById(id);
    }

    @GetMapping("films")
    @ResponseStatus(HttpStatus.OK)
    public List<FilmResponse> getAllFilms() {
        return filmService.getFilms();
    }

    @PatchMapping("film/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FilmResponse updateFilm(@RequestBody @Valid FilmRequest filmRequest,
                                   @PathVariable @NotNull Long id) {
        return filmService.updateFilm(filmRequest, id);
    }

    @DeleteMapping("film/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFilm(@PathVariable @NotNull Long id) {
        filmService.deleteFilm(id);
    }
}