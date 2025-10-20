import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Film } from '../models/film';
import { Page } from '../models/page';
import { FILM_ENDPOINT } from './api';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  constructor(private http: HttpClient) { }

  getFilmsPaginated(): Observable<Page<Film>> {
    return this.http.get<Page<Film>>(FILM_ENDPOINT);
  }
}
