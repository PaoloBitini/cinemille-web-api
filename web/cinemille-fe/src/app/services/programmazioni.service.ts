import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Programmazione } from '../models/programmazione';
import { Page } from '../models/page';
import { map, Observable } from 'rxjs';
import { PROG_ENDPOINT } from './api';
import { PageRequest } from '../models/pageRequest';
import { ProgrammazioniFilters } from '../models/programmazioniFilters';

@Injectable({
  providedIn: 'root'
})
export class ProgrammazioniService {
  constructor(private http: HttpClient) { }

  getProgrammazioniPaginated(paging: PageRequest): Observable<Page<Programmazione>> {
    return this.http.get<Page<Programmazione>>(PROG_ENDPOINT, {
      params: {
        ...paging,
      }
    }).pipe(
      map(page => ({
        ...page,
        content: page.content.map(data => ({
          ...data,
          proiezione: new Date(data.proiezione)
        }))
      })
      ))
  }

  getProgrammazioniFilteredAndPaginated(paging: PageRequest, filters: ProgrammazioniFilters): Observable<Page<Programmazione>> {
    return this.http.get<Page<Programmazione>>(PROG_ENDPOINT + "/filtered", {
      params: {
        ...paging,
        ...filters
      }
    }).pipe(
      map(page => ({
        ...page,
        content: page.content.map(data => ({
          ...data,
          proiezione: new Date(data.proiezione)
        }))
      })
      ));
  }
}
