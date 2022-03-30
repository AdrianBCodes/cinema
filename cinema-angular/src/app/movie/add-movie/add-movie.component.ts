import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {

  movie: Movie = new Movie();

  constructor(private movieService: MovieService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveMovie(){
    this.movieService.addMovie(this.movie).subscribe(data => {
      console.log(data);
      this.goToMovieList();
    })
  }

  goToMovieList(){
    this.router.navigate(['/movies']);
  }

  onSubmit(){
    console.log(this.movie);
    this.saveMovie();
  }

}
