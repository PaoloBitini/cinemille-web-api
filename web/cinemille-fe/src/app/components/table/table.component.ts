import { Component, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Page } from '../../models/page';
import { PageRequest } from '../../models/pageRequest';

@Component({
  standalone: false,
  selector: 'cm-table',
  templateUrl: './table.component.html',
  styleUrl: './table.component.scss',
})
export class TableComponent {

  @Input() columnToExclude: string[] = []
  @Input() set data(page: Page<any>) {

    this.page = page;

    if (page?.content?.length > 0) {
      this.columns = Object.keys(page.content[0]).filter((el) => !this.columnToExclude.includes(el));
      this.dataSource.data = page.content;
    }
  }
  @Output() paginationChanged: EventEmitter<PageRequest> = new EventEmitter<PageRequest>();

  page: Page<any> = new Page;
  dataSource = new MatTableDataSource<any>([]);
  columns: string[] = [];
  pageSizeOptions: number[] = [5, 10, 20];

  paging: PageRequest = {
    size: 20,
    page: 0
  }

  pagingChanged(pageEvent: PageEvent) {
    this.paging = {
      page: pageEvent.pageIndex,
      size: pageEvent.pageSize
    }
    this.paginationChanged.emit(this.paging);
  }

  isDate(obj: any): boolean {
    return obj instanceof Date;
  }
}
