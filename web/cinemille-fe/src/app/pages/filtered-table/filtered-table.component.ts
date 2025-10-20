import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Page } from '../../models/page';

@Component({
  standalone: false,
  selector: 'cm-filtered-table',
  templateUrl: './filtered-table.component.html',
  styleUrl: './filtered-table.component.scss',
})
export class FilteredTableComponent implements OnInit, AfterViewInit {

  @Input() set setTable(page: Page<any>) {

    this.page = page;
    if (page?.content?.length > 0) {
      this.columns = Object.keys(page.content[0]).filter((el) => !this.columnToExclude.includes(el));
      this.dataSource.data = page.content
    }
  }

  @Input() columnToExclude: string[] = []

  page: Page<any> = new Page;
  pageSizeOptions: number[] = [5, 10, 20];
  defaultPageSize = 10;
  columns: string[] = [];
  dataSource = new MatTableDataSource<any>([]);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngOnInit(): void {
    //this.setTable(this.page);
  }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }

}
