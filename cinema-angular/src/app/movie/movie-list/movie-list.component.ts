import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  public movies: Movie[];

  constructor(private movieService: MovieService,
    private router: Router) { }

  ngOnInit(): void {
    this.getMovies();
  }

  private getMovies(){
      this.movieService.getMoviesList().subscribe(data => {
        this.movies = data;
        console.log(data);
      })
  }

  goToAddMovie(){
    this.router.navigate(['add-movie']);
  }

  editMovie(id:number){
    this.router.navigate(['edit-movie', id]);
  }

  deleteMovie(id:number){
    this.movieService.deleteMovie(id).subscribe(data => {
      console.log(data);
      this.getMovies();
    });
  }

  movieDetails(id:number){
    this.router.navigate(['movie-details', id]);
  }
}
