package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dto.MovieDto;
import pl.coderslab.entity.Genre;
import pl.coderslab.entity.Movie;
import pl.coderslab.repository.GenreRepository;
import pl.coderslab.repository.MovieRepository;
import pl.coderslab.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final MovieService movieService;

    @GetMapping("/test")
    public String test() {
        Genre genre = new Genre();
        genre.setName("Genre");
        Genre genre2 = new Genre();
        genre2.setName("Genre2");
        genreRepository.save(genre);
        genreRepository.save(genre2);

        List<Genre> genres = new ArrayList<>();
        genres.add(genre);
        genres.add(genre2);

        Movie movie = new Movie();
        movie.setTitle("test");
        movie.setReleaseYear(1990);
        movie.setRating(8.0);
        movie.setGenres(genres);
        movieRepository.save(movie);

        Movie movie1 = new Movie();
        movie1.setTitle("test1");
        movie1.setReleaseYear(2000);
        movie1.setRating(10.0);
        movie1.setGenres(genres);
        movieRepository.save(movie1);

        return movie.getTitle() + " " + movie1.getTitle();
    }

    @GetMapping("/{id}")
    public MovieDto getMovieById(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }
}
