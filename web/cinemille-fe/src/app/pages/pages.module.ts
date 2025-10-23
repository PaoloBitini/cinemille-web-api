import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilmPageComponent } from './film-page/film-page.component';
import { ProgrammazioniPageComponent } from './programmazioni-page/programmazioni-page.component';
import { SalePageComponent } from './sale-page/sale-page.component';
import { ComponentsModule } from '../components/components.module';

@NgModule({
  declarations: [
    FilmPageComponent,
    ProgrammazioniPageComponent,
    SalePageComponent,
  ],
  imports: [
    CommonModule,
    ComponentsModule,
  ],
  exports: [
    FilmPageComponent,
    ProgrammazioniPageComponent,
    SalePageComponent,
    ComponentsModule
  ]
})
export class PagesModule { }
