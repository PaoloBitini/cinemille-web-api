import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { TableComponent } from './table/table.component';
import { MaterialModule } from '../material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CdkTableModule } from "@angular/cdk/table";

@NgModule({
  declarations: [
    ToolbarComponent,
    TableComponent,
    SidenavComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
    CdkTableModule
],
  exports: [
    ToolbarComponent,
    TableComponent,
    SidenavComponent,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class ComponentsModule { }
