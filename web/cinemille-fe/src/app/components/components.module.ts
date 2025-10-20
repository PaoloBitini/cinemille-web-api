import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar'
import { MatIconModule } from '@angular/material/icon'
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { FiltriComponent } from './filtri/filtri.component';
import { SidenavComponent } from './sidenav/sidenav.component';

@NgModule({
  declarations: [
    ToolbarComponent,
    FiltriComponent,
    SidenavComponent,
  ],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatSidenavModule,
    MatListModule
  ],
  exports: [
    ToolbarComponent,
    SidenavComponent,
    MatListModule,
    MatIconModule
  ]
})
export class ComponentsModule { }
