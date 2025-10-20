import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Programmazione } from '../models/programmazione';
import { Page } from '../models/page';
import { Observable } from 'rxjs';
import { PROG_ENDPOINT } from './api';

@Injectable({
  providedIn: 'root'
})
export class ProgrammazioniService {
  constructor(private http: HttpClient) { }

  getProgrammazioniPaginated(): Observable<Page<Programmazione>> {
    return this.http.get<Page<Programmazione>>(PROG_ENDPOINT);
  }
}
