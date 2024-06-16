import { Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {RecipeComponent} from "./recipe/recipe.component";
import {AuthGuard} from "./recipe-guard.guard";

export const routes: Routes = [
  {path: '', redirectTo: '/recipe', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'recipe', component: RecipeComponent, canActivate: [AuthGuard]},
];
