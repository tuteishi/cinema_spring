package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.CreateFilmRequest;
import by.cinema.cinema_web.dto.responses.FilmResponse;
import by.cinema.cinema_web.entities.Film;
import by.cinema.cinema_web.exceptions.FilmNotFoundException;
import by.cinema.cinema_web.mappers.FilmMapper;
import by.cinema.cinema_web.repositories.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;
    private final TicketService ticketService;

    @Override
    @Transactional
    public FilmResponse creatFilm(CreateFilmRequest filmRequest) {
        Film film = filmMapper.filmRequestToFilm(filmRequest);
        filmRepository.save(film);
        ticketService.createTikets(film);
        return filmMapper.filmToFilmResponse(film);
    }

    @Override
    @Transactional(readOnly = true)
    public FilmResponse getFilmById(Long filmId) {
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new FilmNotFoundException(filmId.toString()));
        return filmMapper.filmToFilmResponse(film);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FilmResponse> getAllFilms() {
        List<Film> allFilms = filmRepository.findAll();
        return filmMapper.filmListToFilmResponseList(allFilms);
    }

    @Override
    @Transactional
    public FilmResponse updateFilm(CreateFilmRequest filmRequest, Long filmId) {
        Film film = filmMapper.filmRequestToFilm(filmRequest);
        film.setFilmId(filmId);
        filmRepository.save(film);
        return filmMapper.filmToFilmResponse(film);
    }

    @Override
    @Transactional
    public void deleteFilm(Long filmId) {
        filmRepository.deleteById(filmId);
    }
}