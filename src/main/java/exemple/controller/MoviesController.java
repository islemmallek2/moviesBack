package exemple.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exemple.model.Movies;
import exemple.service.MoviesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MoviesController {

	@Autowired
	MoviesService moviesService;

	@GetMapping("/movies")
	public Page<Movies> getAllMovies(@RequestParam String globalFilter, @RequestParam int page,
			@RequestParam int size) {
		return moviesService.getAll(globalFilter, page, size);
	}

	@GetMapping("/movies/{id}")
	public Optional<Movies> getMovies(@PathVariable("id") Long id) {
		return moviesService.FindById(id);
	}

	@PostMapping(value = "/movies/create")
	public Movies postMovies(@RequestBody Movies movies) {
		return moviesService.save(movies);
	}

	@DeleteMapping(value = "/movies/{id}")
	public void deleteMovies(@PathVariable("id") Long id) {
		moviesService.delete(id);
	}

	@PutMapping(value = "/movies/{id}")
	public Movies updateMovies(@PathVariable("id") long id, @RequestBody Movies movies) {
		return moviesService.update(id, movies);
	}
}
