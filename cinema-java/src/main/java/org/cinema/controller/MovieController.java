package org.cinema.controller;

import org.cinema.movie.Movie;
import org.cinema.movie.MovieBuilder;
import org.cinema.movie.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    ResponseEntity<List<Movie>> findAllMovies(){
        return ResponseEntity.ok(movieService.findAllMovies());
    }

    @PostMapping
    ResponseEntity<Long> addMovie(@RequestBody MovieWriteModel toAdd) {
        var movieToAdd =
                MovieBuilder.builder()
                        .withName(toAdd.getName())
                        .withDate(toAdd.getDate())
                        .withDescription(toAdd.getDescription())
                        .withLength(toAdd.getLength())
                        .withTicketPrice(toAdd.getTicketPrice())
                        .build();
        var movieId = movieService.addMovie(movieToAdd);
        return ResponseEntity.ok(movieId);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> editMovie(@PathVariable Long id, @RequestBody MovieWriteModel toEdit) {
        var movieToEdit =
                MovieBuilder.builder()
                        .withId(id)
                        .withName(toEdit.getName())
                        .withDate(toEdit.getDate())
                        .withDescription(toEdit.getDescription())
                        .withLength(toEdit.getLength())
                        .withTicketPrice(toEdit.getTicketPrice())
                        .build();
        movieService.editMovie(movieToEdit);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    ResponseEntity<Movie> findMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.findMovieById(id));
    }

    @PostMapping("/{id}")
    ResponseEntity<Long> copyMovieWithNewDate(@PathVariable Long id, @RequestBody CopyMovieWithAnotherDate dateForAnotherMovie){
        var movieToCopy = movieService.findMovieById(id);
        var newMovie =
                MovieBuilder.builder()
                        .withName(movieToCopy.getName())
                        .withDate(dateForAnotherMovie.dateTime)
                        .withDescription(movieToCopy.getDescription())
                        .withLength(movieToCopy.getLength())
                        .withTicketPrice(movieToCopy.getTicketPrice())
                        .build();
        var newMovieId = movieService.addMovie(newMovie);
        return ResponseEntity.ok(newMovieId);
    }

    @GetMapping("/search/{numberOfSeats}")
    ResponseEntity<List<Movie>> findAllMoviesWithBelowOccupiedSeats(@PathVariable int numberOfSeats){
        return ResponseEntity.ok(movieService.findAllMoviesWithBelowOccupiedSeats(numberOfSeats));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Long> deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
        return ResponseEntity.ok(id);
    }

}
