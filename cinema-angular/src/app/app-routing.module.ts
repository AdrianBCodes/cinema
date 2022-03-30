import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddMovieComponent } from './movie/add-movie/add-movie.component';
import { EditMovieComponent } from './movie/edit-movie/edit-movie.component';
import { HomePageComponent } from './home-page/home-page.component';
import { MovieDetailsComponent } from './movie/movie-details/movie-details.component';
import { MovieListComponent } from './movie/movie-list/movie-list.component';
import { TicketListComponent } from './ticket/ticket-list/ticket-list.component';
import { AddTicketComponent } from './ticket/add-ticket/add-ticket.component';

const routes: Routes = [
  {path: 'movies', component: MovieListComponent},
  {path: '', component: HomePageComponent},
  {path: 'add-movie', component: AddMovieComponent},
  {path: 'edit-movie/:id', component: EditMovieComponent},
  {path: 'movie-details/:id', component: MovieDetailsComponent},
  {path: 'tickets', component: TicketListComponent},
  {path: 'add-ticket', component: AddTicketComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
