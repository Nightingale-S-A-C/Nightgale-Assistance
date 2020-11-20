import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DefaultComponent} from './components/default/default.component';
import {NosotrosComponent} from './components/nosotros/nosotros.component';
import {ContactoComponent} from './components/contacto/contacto.component';
import {LoginComponent} from './components/login/login.component';
import {ProductListComponent} from './components/product/product-list/product-list.component';
import {ProductCreateComponent} from './components/product/product-create/product-create.component';
import {ProductUpdateComponent} from './components/product/product-update/product-update.component';

const routes: Routes = [
  {path: '', component: DefaultComponent},
  {path: 'nosotros', component: NosotrosComponent},
  {path: 'contacto', component: ContactoComponent},
  {
    path: 'producto',
    children: [
      {path: '', component: ProductListComponent},
      {path: 'create', component: ProductCreateComponent},
      {path: ':id/update', component: ProductUpdateComponent}
    ]
  },
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
