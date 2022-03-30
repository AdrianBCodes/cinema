import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private baseURL = "http://localhost:8080/api/v1/movies"

  constructor(private httpClient : HttpClient) { }

  getMoviesList(): Observable<Movie[]>{
    return this.httpClient.get<Movie[]>(this.baseURL);
  }

  getMovieById(id: number): Observable<Movie>{
    return this.httpClient.get<Movie>(this.baseURL + '/' + id);
  }

  addMovie(movie: Movie): Observable<Object>{
    return this.httpClient.post<Object>(this.baseURL, movie);
  }

  editMovie(id: number, movie: Movie): Observable<Object>{
    return this.httpClient.put<Object>(this.baseURL + '/' + id, movie);
  }

  deleteMovie(id: number): Observable<Object>{
    return this.httpClient.delete(this.baseURL + '/' + id);
  }
}
