package org.cinema.movie.infrastructure;

import org.cinema.movie.Movie;
import org.cinema.movie.MovieMapper;
import org.cinema.movie.MovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public interface SqlMovieRepository extends MovieRepository, JpaRepository<MovieEntity, Long>{

    @Query(
            nativeQuery = true,
            value = "SELECT * from movies where length(occupied_seats) - length(replace(occupied_seats,',','')) + 1 < :numberOfSeats")
    List<MovieEntity> findAllByOccupiedSeats(@Param("numberOfSeats") int numberOfSeats);

    @Override
    default List<Movie> findAllMovies(){
        return this.findAll().stream().map(MovieMapper::entityToMovie).collect(Collectors.toList());
    }

    @Override
    default Optional<Movie> findMovieById(Long id) {
        return this.findById(id).map(MovieMapper::entityToMovie);
    }

    @Override
    default Long save(Movie movie) {
        var movieEntity = this.save(MovieMapper.movieToEntity(movie));
        return movieEntity.getId();
    }

    @Override
    default List<Movie> findAllMoviesWithBelowOccupiedSeats(int numberOfSeats) {
        return this.findAllByOccupiedSeats(numberOfSeats).stream().map(MovieMapper::entityToMovie).collect(Collectors.toList());
    }

    @Override
    default void deleteMovieById(Long id){
        this.deleteById(id);
    }
}
