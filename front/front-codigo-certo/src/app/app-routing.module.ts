import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './authGuard';
import { ProjectListComponent } from './project-list/project-list.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent }, // Rota para o login
  { path: 'projetos', component: ProjectListComponent, canActivate: [AuthGuard] }, // Rota para projetos com guarda de rota
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Rota principal redireciona para o login
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
