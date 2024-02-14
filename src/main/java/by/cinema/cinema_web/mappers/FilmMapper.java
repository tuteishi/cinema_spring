package by.cinema.cinema_web.mappers;

import by.cinema.cinema_web.dto.requests.CreateFilmRequest;
import by.cinema.cinema_web.dto.responses.FilmResponse;
import by.cinema.cinema_web.entities.Film;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    Film filmRequestToFilm(CreateFilmRequest filmRequest);

    FilmResponse filmToFilmResponse(Film film);

    List<FilmResponse> filmListToFilmResponseList(List<Film> films);
}
