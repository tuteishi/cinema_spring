package by.cinema.cinema_web.mappers;

import by.cinema.cinema_web.dto.requests.FilmRequest;
import by.cinema.cinema_web.dto.responses.FilmResponse;
import by.cinema.cinema_web.entities.Film;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    Film mapFilmRequestToFilm(FilmRequest filmRequest);

    FilmResponse mapFilmToFilmResponse(Film film);

    List<FilmResponse> mapFilmListToFilmResponseList(List<Film> films);
}
