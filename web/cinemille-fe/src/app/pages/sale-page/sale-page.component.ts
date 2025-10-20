import { Component } from '@angular/core';
import { SaleService } from '../../services/sale.service';
import { Sala } from '../../models/sala';
import { Page } from '../../models/page';

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

  ngOnInit(): void {
    this.saleService.getFilmsPaginated().subscribe({
      next: (el: Page<Sala>) => {
        this.data = el;
      }
    })
  }
}
