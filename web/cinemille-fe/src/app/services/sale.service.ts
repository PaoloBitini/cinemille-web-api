import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Page } from '../models/page';
import { Observable } from 'rxjs';
import { Sala } from '../models/sala';
import { SALE_ENDPOINT } from './api';
import { PageRequest } from '../models/pageRequest';

@Injectable({
  providedIn: 'root'
})
export class SaleService {
  constructor(private http: HttpClient) { }

  getSalePaginated(paging: PageRequest): Observable<Page<Sala>> {
    return this.http.get<Page<Sala>>(SALE_ENDPOINT, {
      params: {
        ...paging
      }
    });
  }
}
