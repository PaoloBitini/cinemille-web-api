import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Film } from '../models/film';
import { Page } from '../models/page';
import { FILM_ENDPOINT } from './api';
import { map, Observable } from 'rxjs';
import { PageRequest } from '../models/pageRequest';
import { FilmFilters } from '../models/filmFilters';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  constructor(private http: HttpClient) { }

  getFilmsPaginated(paging: PageRequest): Observable<Page<Film>> {
    return this.http.get<Page<Film>>(FILM_ENDPOINT, {
      params: {
        ...paging,
      }
    }).pipe(
      map((page) => ({
        ...page,
        content: page.content.map((data) => ({
          ...data,
          dataFinePermanenza: new Date(data.dataFinePermanenza),
          dataUscita: new Date(data.dataUscita)
        }))
      })));
  }

  getFilmsFilteredAndPaginated(paging: PageRequest, filters: FilmFilters): Observable<Page<Film>> {
    return this.http.get<Page<Film>>(FILM_ENDPOINT + "/filtered", {
      params: {
        ...paging,
        ...filters
      }
    }).pipe(
      map((page) => ({
        ...page,
        content: page.content.map((data) => ({
          ...data,
          dataFinePermanenza: new Date(data.dataFinePermanenza),
          dataUscita: new Date(data.dataUscita)
        }))
      })));;
  }
}
