package exemple.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import exemple.model.Movies;

public interface MoviesRepo extends CrudRepository<Movies, Long>{
	
    @Query("SELECT s FROM Movies s where  "
            +  "( s.title like %:filtre% or s.releaseDate like %:filtre% or  s.director like %:filtre%"
            + " or s.type like %:filtre% ) ")
	public Page<Movies> findAllMovies(@Param("filtre") String filtre, Pageable pageable) ;
    
    public Page<Movies> findAll(Pageable pageable);

}
