package exemple.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import exemple.model.Movies;

public interface MoviesService {

	Page<Movies> getAll(String globalFilter, int page, int size);

	Optional<Movies> FindById(Long id);

	Movies save(Movies moviesjson);

	Movies update(long id, Movies movies);

	void delete(Long moviesId);
}
