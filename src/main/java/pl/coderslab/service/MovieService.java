package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.MovieDto;
import pl.coderslab.mapper.MovieMapper;
import pl.coderslab.repository.MovieRepository;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieDto getMovieById(Long id) {
        return movieRepository.findById(id)
                .map(movieMapper::toDto)
                .orElse(null);
    }
}
