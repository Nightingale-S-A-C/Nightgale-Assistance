import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../../services/product.service';
import {Product} from '../../../models/product.model';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  public products: Product[] = [];
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll(): void {
    this.productService.getAll().subscribe((data) => {
      this.products = data;
    });
  }

}
