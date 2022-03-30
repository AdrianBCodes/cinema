package org.cinema.movie;

import java.util.*;
import java.util.stream.Collectors;

public class FakeMovieRepository implements MovieRepository {
    private final Map<Long, Movie> movies = new HashMap<>();

    @Override
    public List<Movie> findAllMovies() {
        return movies.values().stream().toList();
    }

    @Override
    public Optional<Movie> findMovieById(Long id) {
        return Optional.ofNullable(movies.get(id));
    }

    @Override
    public Long save(Movie entity) {
        if(entity.getId() == null){
            var index = Collections.max(movies.keySet())+1;
            var indexedMovie = new Movie(index, entity.getName(), entity.getDescription(), entity.getDate(), entity.getTicketPrice(), entity.getOccupiedSeats(), entity.getLength());
            movies.put(index, indexedMovie);
            return index;
        }
        movies.put(entity.getId(), entity);
        return entity.getId();
    }

    @Override
    public List<Movie> findAllMoviesWithBelowOccupiedSeats(int numberOfSeats) {
        return movies.values().stream().filter(movie -> movie.getOccupiedSeats().size() <= numberOfSeats).collect(Collectors.toList());
    }

    @Override
    public void deleteMovieById(Long id) {
        movies.remove(id);
    }
}
