import { Component } from '@angular/core';
import { ProgrammazioniService } from '../../services/programmazioni.service';
import { Programmazione } from '../../models/programmazione';
import { Page } from '../../models/page';
import { FormBuilder, FormGroup } from '@angular/forms';


export interface ProgrammazioniFilters {
  titolo: string,
  regista: string,
  genere: string,
  sala: string,
  daProiezione: Date | null;
  aProiezione: Date | null;
}

@Component({
  selector: 'cm-programmazioni-page',
  standalone: false,
  templateUrl: './programmazioni-page.component.html',
  styleUrl: './programmazioni-page.component.scss'
})
export class ProgrammazioniPageComponent {
  constructor(private progService: ProgrammazioniService, private formBuilder: FormBuilder) { }

  form: FormGroup = this.formBuilder.group<ProgrammazioniFilters>({
    titolo: "",
    regista: "",
    genere: "",
    sala: "",
    daProiezione: null,
    aProiezione: null,
  });

  data: any;

  filterOpened: boolean = false;

  columnToExclude: string[] = ["uuidFilm", "uuidSala"];

  ngOnInit(): void {
    this.progService.getProgrammazioniPaginated().subscribe({
      next: (el: Page<Programmazione>) => {
        this.data = el;
      }
    })
  }
}
