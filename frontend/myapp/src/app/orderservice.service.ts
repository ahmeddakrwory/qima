import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderserviceService {

  constructor(private httpclient:HttpClient) { }
  getallusers(pnum:any){
    return this.httpclient.get("http://localhost:8090/order/allorders");
  }
}
