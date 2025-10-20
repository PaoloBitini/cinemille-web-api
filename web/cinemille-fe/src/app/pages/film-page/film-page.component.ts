import { Component, OnInit } from '@angular/core';
import { FilmService } from '../../services/film.service';
import { Observable } from 'rxjs';
import { Page } from '../../models/page';
import { Film } from '../../models/film';

@Component({
  selector: 'cm-film-page',
  standalone: false,
  templateUrl: './film-page.component.html',
  styleUrl: './film-page.component.scss'
})
export class FilmPageComponent implements OnInit {

  constructor(private filmService: FilmService) { }

  data: any;

  columnToExclude = ["uuid", "descrizione"];

  ngOnInit(): void {
    this.filmService.getFilmsPaginated().subscribe({
      next: (el: Page<Film>) => {
        this.data = el;
      }
    })
  }

}
