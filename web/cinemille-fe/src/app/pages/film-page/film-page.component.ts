import { Component, OnDestroy, OnInit } from '@angular/core';
import { FilmService } from '../../services/film.service';
import { Page } from '../../models/page';
import { Film } from '../../models/film';
import { FormBuilder, FormGroup } from '@angular/forms';
import { defaultPageRequest, PageRequest } from '../../models/pageRequest';
import { invalidDateValidator, notJustOneDate } from '../../validators/dateValidators';
import { from, merge, Subscription } from 'rxjs';
import { defaultFilmFilter, FilmFilters } from '../../models/filmFilters';
import { formatDateToString, isControlInvalid, isEmptyFilmFilter } from '../../utils';


@Component({
  selector: 'cm-film-page',
  standalone: false,
  templateUrl: './film-page.component.html',
  styleUrl: './film-page.component.scss'
})
export class FilmPageComponent implements OnInit, OnDestroy {

  constructor(private filmService: FilmService, private formBuilder: FormBuilder) { }

  filterOpened: boolean = false;
  disabledSearch: boolean = true;

  sub: Subscription | null = null;

  data: any;
  columnToExclude = ["uuid", "descrizione"];

  filters: FilmFilters = defaultFilmFilter();
  paging: PageRequest = defaultPageRequest();

  form: FormGroup = this.formBuilder.group<FilmFilters>({
    ...this.filters
  })


  ngOnInit(): void {
    this.loadData()

    //Validatori per le date
    this.form.controls['daDataUscita'].addValidators(invalidDateValidator);
    this.form.controls['aDataUscita'].addValidators(invalidDateValidator);
    this.form.controls['daDataFinePermanenza'].addValidators(invalidDateValidator);
    this.form.controls['aDataFinePermanenza'].addValidators(invalidDateValidator);
    this.form.addValidators(notJustOneDate("daDataUscita", "aDataUscita"));
    this.form.addValidators(notJustOneDate("daDataFinePermanenza", "aDataFinePermanenza"));

    //Abilitazione e disabilitazione bottone "Cerca" dei filtri
    this.sub = merge(this.form.valueChanges, this.form.statusChanges).subscribe({
      next: (val) => {

        if (!val || val === 'VALID') {
          return;
        }

        if (val === 'INVALID' || isEmptyFilmFilter(val)) {
          this.disabledSearch = true;
        } else {
          this.disabledSearch = false;
        }
      }
    });

  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe()
  }

  onPaginationChange(paging: PageRequest) {
    this.paging = paging;
    this.loadData();
  }

  onFilterChange() {
    this.filters = this.form.getRawValue();
    this.filters.daDataUscita = formatDateToString(this.filters.daDataUscita);
    this.filters.aDataUscita = formatDateToString(this.filters.aDataUscita);
    this.filters.daDataFinePermanenza = formatDateToString(this.filters.daDataFinePermanenza);
    this.filters.aDataFinePermanenza = formatDateToString(this.filters.aDataFinePermanenza);
    this.loadData();
  }

  loadData() {
    if (isEmptyFilmFilter(this.filters)) {
      this.filmService.getFilmsPaginated(this.paging).subscribe({
        next: (el: Page<Film>) => {
          this.data = el;
        }
      })
    } else {
      this.filmService.getFilmsFilteredAndPaginated(this.paging, this.filters).subscribe({
        next: (el: Page<Film>) => {
          this.data = el;
        }
      })
    }
  }

  deleteFilters() {
    this.form.reset();
  }

  isDataUscitaValid() {
    return isControlInvalid(this.form, 'daDataUscita') || isControlInvalid(this.form, 'aDataUscita')
  }

  isDataFinePermanenzaValid() {
    return isControlInvalid(this.form, 'daDataFinePermanenza') || isControlInvalid(this.form, 'aDataFinePermanenza')
  }
}
