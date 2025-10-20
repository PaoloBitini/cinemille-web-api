import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { FilteredTableComponent } from './filtered-table/filtered-table.component';
import { FilmPageComponent } from './film-page/film-page.component';
import { ProgrammazioniPageComponent } from './programmazioni-page/programmazioni-page.component';
import { SalePageComponent } from './sale-page/sale-page.component';

@NgModule({
  declarations: [
    FilteredTableComponent,
    FilmPageComponent,
    ProgrammazioniPageComponent,
    SalePageComponent,
  ],
  imports: [
    CommonModule,
    MatPaginatorModule,
    MatTableModule,
  ],
  exports: [
    FilteredTableComponent,
    FilmPageComponent,
    ProgrammazioniPageComponent,
    SalePageComponent,
  ]
})
export class PagesModule { }
