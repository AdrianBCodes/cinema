import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-edit-movie',
  templateUrl: './edit-movie.component.html',
  styleUrls: ['./edit-movie.component.css']
})
export class EditMovieComponent implements OnInit {

  id: number;
  movie: Movie = new Movie();

  constructor(private movieService: MovieService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.movieService.getMovieById(this.id).subscribe({
      next: (data) => this.movie = data,
      error: console.error
    })
  }

  goToMovieList(){
    this.router.navigate(['/movies']);
  }

  onSubmit(){
    this.movieService.editMovie(this.id, this.movie).subscribe({
      next: () => this.goToMovieList(),
      error: console.error
    })
  }
}
