import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {RecipeComponent} from "./recipe/recipe.component";
import {CommonModule} from "@angular/common";
import {LoginComponent} from "./login/login.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RecipeComponent, CommonModule, LoginComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'MAS-FE';
}
