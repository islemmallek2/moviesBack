package exemple.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import exemple.model.Movies;
import exemple.repository.MoviesRepo;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	MoviesRepo moviesRepo;

	@Override
	public Page<Movies> getAll(String globalFilter, int page, int size) {
		try {
			if (globalFilter.equalsIgnoreCase("null")) {
				return moviesRepo.findAll(PageRequest.of(page, size));
			} else
				return moviesRepo.findAllMovies(globalFilter, PageRequest.of(page, size));
		} catch (Exception e) {
			System.err.println("movies error");
			System.err.println(e.toString());
			System.err.println("movies error");
			return null;
		}
	}

	@Override
	public Optional<Movies> FindById(Long id) {
		try {
			return moviesRepo.findById(id);
		} catch (Exception e) {
			System.err.println("moviesByid error");
			System.err.println(e.toString());
			System.err.println("moviesByid error");
			return null;
		}
	}

	@Override
	public Movies save(Movies moviesjson) {
		try {
			Movies movies = moviesRepo.save(new Movies(moviesjson.getTitle(), moviesjson.getReleaseDate(),
					moviesjson.getDirector(), moviesjson.getType()));
			return movies;
		} catch (Exception e) {
			System.err.println("movies save error");
			System.err.println(e.toString());
			System.err.println("movies save error");
			return null;
		}
	}

	@Override
	public Movies update(long id, Movies movies) {
		try {
			Optional<Movies> moviesData = moviesRepo.findById(id);
			if (moviesData.isPresent()) {
				Movies getMovies = moviesData.get();
				getMovies.setDirector(movies.getDirector());
				getMovies.setTitle(movies.getTitle());
				getMovies.setType(movies.getType());
				getMovies.setReleaseDate(movies.getReleaseDate());
				moviesRepo.save(getMovies);
				return getMovies;
			}
			return null;
		} catch (Exception e) {
			System.err.println("movies update error");
			System.err.println(e.toString());
			System.err.println("movies update error");
			return null;
		}
	}

	@Override
	public void delete(Long moviesId) {
		try {
			moviesRepo.deleteById(moviesId);
		} catch (Exception e) {
			System.err.println("movies delete error");
			System.err.println(e.toString());
			System.err.println("movies delete error");
		}
	}

}
