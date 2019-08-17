import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NavComponent } from './nav/nav.component';
import { LoginComponent } from './login/login.component';
import { TraderComponent } from './nav/trader/trader.component';


const routes: Routes = [
  /*{
    path: '',
    loadChildren: () =>
    import('./login/login.module').then(
      m => m.LoginModule
    )
  },*/

  {
    path: '',
    component: LoginComponent
  },

  {
    path: 'sidenav',
    component: NavComponent
  },

  {
    path: 'trader',
    component: TraderComponent
  },

  {
    path: '**',
    redirectTo: '',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
