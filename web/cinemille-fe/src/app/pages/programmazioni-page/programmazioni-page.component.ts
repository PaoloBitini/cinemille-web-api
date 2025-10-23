import { Component, OnDestroy, OnInit } from '@angular/core';
import { ProgrammazioniService } from '../../services/programmazioni.service';
import { Programmazione } from '../../models/programmazione';
import { Page } from '../../models/page';
import { FormBuilder, FormGroup } from '@angular/forms';
import { defaultPageRequest, PageRequest } from '../../models/pageRequest';
import { invalidDateValidator, notJustOneDate } from '../../validators/dateValidators';
import { merge, Subscription } from 'rxjs';
import { defaultProgramamzioniFilters, ProgrammazioniFilters } from '../../models/programmazioniFilters';
import { formatDateToString, isControlInvalid, isEmptyProgrammazioniFilter } from '../../utils';

@Component({
  selector: 'cm-programmazioni-page',
  standalone: false,
  templateUrl: './programmazioni-page.component.html',
  styleUrl: './programmazioni-page.component.scss'
})
export class ProgrammazioniPageComponent implements OnInit, OnDestroy {

  constructor(private progService: ProgrammazioniService, private formBuilder: FormBuilder) { }

  filterOpened: boolean = false;
  disabledSearch: boolean = true;

  sub: Subscription | null = null;

  data: any;
  columnToExclude: string[] = ["uuidFilm", "uuidSala", "uuid"];

  filters: ProgrammazioniFilters = defaultProgramamzioniFilters();
  paging: PageRequest = defaultPageRequest();

  form: FormGroup = this.formBuilder.group<ProgrammazioniFilters>({
    ...this.filters
  });


  ngOnInit(): void {

    this.loadData();

    //Validatori per le date
    this.form.controls['daProiezione'].addValidators(invalidDateValidator);
    this.form.controls['aProiezione'].addValidators(invalidDateValidator);
    this.form.addValidators(notJustOneDate("daProiezione", "aProiezione"));

    //Abilitazione e disabilitazione bottone "Cerca" dei filtri
    this.sub = merge(this.form.valueChanges, this.form.statusChanges).subscribe({
      next: (val) => {

        if (!val || val === 'VALID') {
          return;
        }

        if (val === 'INVALID' || isEmptyProgrammazioniFilter(val)) {
          this.disabledSearch = true;
        } else {
          this.disabledSearch = false;
        }
      }
    });
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

  loadAllData() {
    this.progService.getProgrammazioniPaginated(this.paging).subscribe({
      next: (el: Page<Programmazione>) => {
        this.data = el;
      }
    });
  }

  loadData() {
    if (isEmptyProgrammazioniFilter(this.filters)) {
      this.loadAllData();
    } else {
      this.progService.getProgrammazioniFilteredAndPaginated(this.paging, this.filters).subscribe({
        next: (el: Page<Programmazione>) => {
          this.data = el;
        }
      })
    }
  }

  onPaginationChanges(paging: PageRequest) {
    this.paging = paging;
    this.loadData();
  }

  deleteFilters() {
    this.form.reset();
  }

  onFilterChanges() {
    this.filters = this.form.getRawValue();
    this.filters.daProiezione = formatDateToString(this.filters.daProiezione);
    this.filters.aProiezione = formatDateToString(this.filters.aProiezione);
    this.loadData();
  }

  isDataProiezioneValid() {
    return isControlInvalid(this.form, 'daProiezione') || isControlInvalid(this.form, 'aProiezione')
  }
}
