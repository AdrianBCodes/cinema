package org.cinema.movie;

import org.cinema.common.Seat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public Long addMovie(Movie toSave){
        return movieRepository.save(toSave);
    }

    public void editMovie(Movie toEdit){
        movieRepository.save(toEdit);
    }

    public Movie findMovieById(Long id){
        var result = movieRepository.findMovieById(id);
        if(result.isEmpty())
            throw new RuntimeException("Movie with id: " + id + " has not been found");
        return result.get();
    }

    void copyMovieWithNewDate(Long id, LocalDateTime dateTime){
        var result = findMovieById(id).copyMovieWithNewDate(dateTime);
        movieRepository.save(result);
    }

    public List<Movie> findAllMoviesWithBelowOccupiedSeats(int numberOfSeats){
        return movieRepository.findAllMoviesWithBelowOccupiedSeats(numberOfSeats);
    }

     public void assignSeatToMovie(Movie movie, Seat seat){
        var updatedMovie = movie.assignSeatToMovie(seat);
        movieRepository.save(updatedMovie);
    }

    public void deleteMovieById(Long id){
        movieRepository.deleteMovieById(id);
    }
}
