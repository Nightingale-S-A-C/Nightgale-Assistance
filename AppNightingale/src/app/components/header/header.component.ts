import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  signOut(): void{
    // limpiar token session storage
    // cambiar isAutenticaction a false
    // navegar a ruta login
    this.router.navigate(['/login']);
  }
}
