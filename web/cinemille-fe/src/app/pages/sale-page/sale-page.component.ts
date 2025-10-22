import { Component } from '@angular/core';
import { SaleService } from '../../services/sale.service';
import { Sala } from '../../models/sala';
import { Page } from '../../models/page';
import { PageRequest } from '../../models/pageRequest';

@Component({
  selector: 'cm-sale-page',
  standalone: false,
  templateUrl: './sale-page.component.html',
  styleUrl: './sale-page.component.scss'
})
export class SalePageComponent {
  constructor(private saleService: SaleService) { }

  data: any;

  columnToExclude = ["uuid"];

  paging: PageRequest = {
    page: 0,
    size: 12
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadDataNewPagination(paging: PageRequest) {
    this.paging = paging;
    this.loadData();
  }

  loadData() {
    this.saleService.getSalePaginated(this.paging).subscribe({
      next: (el: Page<Sala>) => {
        this.data = el;
      }
    })
  }
}
