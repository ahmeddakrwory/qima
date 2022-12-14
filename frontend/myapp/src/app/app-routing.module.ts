import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LogincComponent } from './loginc/loginc.component';
import { OrdersComponent } from './orders/orders.component';

const routes: Routes = [
  {
  path:"",
  component:LogincComponent

  },
  {
    path:"orders",
    component:OrdersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
