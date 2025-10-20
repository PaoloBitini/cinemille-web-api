import { Component, OnInit } from '@angular/core';
import { FilmService } from '../../services/film.service';
import { Page } from '../../models/page';
import { Film } from '../../models/film';
import { FormBuilder, FormGroup } from '@angular/forms';


export interface FilmFilters {
  uuid: string,
  titolo: string,
  regista: string,
  genere: string,
  daDataUscita: Date | null,
  aDataUscita: Date | null,
  daDataFinePermanenza: Date | null,
  aDataFinePermanenza: Date | null
}

@Component({
  selector: 'cm-film-page',
  standalone: false,
  templateUrl: './film-page.component.html',
  styleUrl: './film-page.component.scss'
})
export class FilmPageComponent implements OnInit {

  constructor(private filmService: FilmService, private formBuilder: FormBuilder) { }

  filterOpened: boolean = false;

  data: any;
  columnToExclude = ["uuid", "descrizione"];

  form: FormGroup = this.formBuilder.group<FilmFilters>({
    uuid: "",
    titolo: "",
    regista: "",
    genere: "",
    daDataUscita: null,
    aDataUscita: null,
    daDataFinePermanenza: null,
    aDataFinePermanenza: null
  })


  ngOnInit(): void {
    this.filmService.getFilmsPaginated().subscribe({
      next: (el: Page<Film>) => {
        this.data = el;
      }
    })
  }

}
