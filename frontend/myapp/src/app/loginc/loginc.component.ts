import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '@auth0/auth0-angular';
@Component({
  selector: 'app-loginc',
  templateUrl: './loginc.component.html',
  styleUrls: ['./loginc.component.css']
})
export class LogincComponent implements OnInit {

logidin=0;

  constructor(public auth: AuthService,private routr:Router) {}


  ngOnInit() {

  }
  login(){

    this.auth.loginWithRedirect({
      appState: { target: '/orders' }
    })


      }

  }

