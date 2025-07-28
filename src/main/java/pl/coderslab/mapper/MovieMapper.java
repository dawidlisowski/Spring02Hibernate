package pl.coderslab.mapper;

import org.springframework.stereotype.Component;
import pl.coderslab.dto.MovieDto;
import pl.coderslab.entity.Movie;

@Component
public class MovieMapper {

    public MovieDto toDto(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getReleaseYear(),
                movie.getGenres(),
                movie.getRating()
        );
    }
}
