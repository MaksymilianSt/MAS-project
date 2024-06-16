import {Component, Input} from '@angular/core';
import {CommonModule} from "@angular/common";
import {Ingredient} from "../Models/Ingredient";

@Component({
  selector: 'app-ingredient',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ingredient.component.html',
  styleUrl: './ingredient.component.css'
})
export class IngredientComponent {
  @Input()
  ingredients: Ingredient[] = [];


}
