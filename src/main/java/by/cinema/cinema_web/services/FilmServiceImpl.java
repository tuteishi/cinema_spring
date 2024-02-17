package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.FilmRequest;
import by.cinema.cinema_web.dto.responses.FilmResponse;
import by.cinema.cinema_web.dto.responses.api.Root;
import by.cinema.cinema_web.entities.Film;
import by.cinema.cinema_web.exceptions.FilmNotFoundException;
import by.cinema.cinema_web.feingClients.DescriptionClient;
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
    private final DescriptionClient descriptionClient;

    @Override
    @Transactional
    public FilmResponse createFilm(FilmRequest filmRequest) {
        Film film = filmMapper.mapFilmRequestToFilm(filmRequest);
        Root description = descriptionClient.getDescription();
        film.setDescription(description.getPosts().get((int) (Math.random() * 25)).getBody());
        filmRepository.save(film);
        ticketService.createTickets(film);
        return filmMapper.mapFilmToFilmResponse(film);
    }

    @Override
    @Transactional(readOnly = true)
    public FilmResponse getFilmById(Long filmId) {
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new FilmNotFoundException(filmId.toString()));
        return filmMapper.mapFilmToFilmResponse(film);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FilmResponse> getFilms() {
        List<Film> allFilms = filmRepository.findAll();
        return filmMapper.mapFilmListToFilmResponseList(allFilms);
    }

    @Override
    @Transactional
    public FilmResponse updateFilm(FilmRequest filmRequest, Long filmId) {
        Film film = filmMapper.mapFilmRequestToFilm(filmRequest);
        film.setFilmId(filmId);
        filmRepository.save(film);
        return filmMapper.mapFilmToFilmResponse(film);
    }

    @Override
    @Transactional
    public void deleteFilm(Long filmId) {
        filmRepository.deleteById(filmId);
    }
}