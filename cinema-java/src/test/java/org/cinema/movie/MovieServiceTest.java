package org.cinema.movie;

import org.cinema.common.Seat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.BDDAssertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.cinema.movie.MovieExample.movie1WithNoSeats;
import static org.cinema.movie.MovieExample.movie2With16Seats;

class MovieServiceTest{
    private MovieService movieService;

    @BeforeEach
    void init(){
        movieService = new MovieService(new FakeMovieRepository());
    }

    @Test
    public void addMovie(){
        //given
        Movie movie = movie1WithNoSeats;
        // when
        movieService.addMovie(movie);
        // then
        assertThat(movieService.findMovieById(1L)).isNotNull();
    }

    @Test
    public void editMovie(){
        //given
        Movie movie = movie1WithNoSeats;
        Movie movie2 = movie2With16Seats;
        movieService.addMovie(movie);
        // when
        movieService.editMovie(movie2);
        // then
        assertThat(movieService.findMovieById(1L)).isNotNull();
        assertThat(movieService.findMovieById(1L).getName()).isEqualTo("Film1");
    }

    @Test
    public void findMovieById(){
        // given
        Movie movie = movie1WithNoSeats;
        movieService.addMovie(movie);
        // when
        var result = movieService.findMovieById(1L);
        // then
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Film1");
    }

    @Test
    public void findMovieById_throwsException(){
        // given

        // when
        var exception = catchThrowable(() -> movieService.findMovieById(1L));
        // then
        assertThat(exception).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void copyMovieWithNewDate(){
        // given
        Movie movie = movie1WithNoSeats;
        movieService.addMovie(movie);
        // when
        movieService.copyMovieWithNewDate(1L, LocalDateTime.MAX);
        // then
        assertThat(movieService.findMovieById(2L).getDate()).isEqualTo(LocalDateTime.MAX);
    }

    @Test
    public void findAllMoviesWithBelowOccupiedSeats(){
        // given
        Movie movie = movie1WithNoSeats;
        Movie movie2 = movie2With16Seats;
        movieService.addMovie(movie);
        movieService.addMovie(movie2);
        // when
        var result = movieService.findAllMoviesWithBelowOccupiedSeats(15);
        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getId()).isEqualTo(1L);
    }

    @Test
    public void assignSeatToMovie(){
        // given
        Movie movie = movie1WithNoSeats;
        movieService.addMovie(movie);
        // when
        var result = movie.assignSeatToMovie(new Seat("A", 10));
        // then
        assertThat(result.getOccupiedSeats().get(0)).isEqualTo(new Seat("A", 10));
    }

    @Test
    public void findAllMovies() {
        // given
        Movie movie = movie1WithNoSeats;
        movieService.addMovie(movie);
        // when
        var result = movieService.findAllMovies();
        // then
        assertThat(result).size().isEqualTo(1);
    }

    @Test
    public void deleteMovieById() {
        // given
        Movie movie = movie1WithNoSeats;
        movieService.addMovie(movie);
        // when
        movieService.deleteMovieById(movie.getId());
        var exception = catchThrowable(() -> movieService.findMovieById(movie.getId()));
        // then
        assertThat(exception).isInstanceOf(RuntimeException.class);
    }
}