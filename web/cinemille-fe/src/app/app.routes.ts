import { Routes } from '@angular/router';
import { FilmPageComponent } from './pages/film-page/film-page.component';
import { ProgrammazioniPageComponent } from './pages/programmazioni-page/programmazioni-page.component';
import { SalePageComponent } from './pages/sale-page/sale-page.component';
export const routes: Routes = [
    {
        path: '',
        pathMatch: 'full',
        redirectTo: 'films'
    },
    {
        path: 'films',
        component: FilmPageComponent,
        title: 'Films',
    },
    {
        path: 'programmazioni',
        component: ProgrammazioniPageComponent,
        title: 'Programmazioni',
    },
    {
        path: 'sale',
        component: SalePageComponent,
        title: 'Programmazioni',
    }
];
