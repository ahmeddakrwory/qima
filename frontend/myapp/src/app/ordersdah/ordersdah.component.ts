import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-ordersdah',
  templateUrl: './ordersdah.component.html',
  styleUrls: ['./ordersdah.component.css']
})
export class OrdersdahComponent {
  /** Based on the screen size, switch from standard to one column per row */
  orders:any

  constructor(private orderservice: OrderserviceService) {}
  ngOnInit(): void {
    this.orderservice.getallusers(1).subscribe((orders)=>{
      this.orders=orders
    })
  }
}
