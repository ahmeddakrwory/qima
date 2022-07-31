import { Component, OnInit } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  constructor(private Orderservice:OrderserviceService) {}
 ngOnInit(): void {

 }
 showusers(){
  this.Orderservice.getallusers(0).subscribe((user:any)=>{
    console.log(user)
  })
 }

}
