import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {
    
  username: string;
  password: string;
  
  constructor(private router: Router) {}
  
  public login(username: string, password: string) {
      console.log("Username: " + this.username + " | Password: " + this.password);
      // this.router.navigate(['sidenav'], { replaceUrl: true });
      this.router.navigate(['sidenav'], { });
  }
  ngOnInit() {}
}