import {Component, OnInit} from '@angular/core';
import {Recipe} from "../Models/Recipe";
import {AppUser} from "../Models/AppUser";
import {Ingredient} from "../Models/Ingredient";
import {Comment} from "../Models/Comment";
import {CommonModule} from "@angular/common";
import {IngredientComponent} from "../ingredient/ingredient.component";
import {CommentComponent} from "../comment/comment.component";
import {RecipeService} from "./recipe.service";
import {UserService} from "../login/UserService";
import {Router} from "@angular/router";

@Component({
  selector: 'app-recipe',
  standalone: true,
  imports: [CommonModule, IngredientComponent, CommentComponent],
  templateUrl: './recipe.component.html',
  styleUrl: './recipe.component.css'
})
export class RecipeComponent implements OnInit {
  recipes: Recipe [] = []


  public constructor(private recipeService: RecipeService,
                     protected userService: UserService,
                     private router: Router) {
  }

  ngOnInit(): void {
    this.recipeService.fetchAllRecipes()
      .subscribe(data => this.recipes = data);
  }

  addNewComment(text: string, recipeId: number) {
    this.recipeService.addComment(text, this.userService.loggedInUser?.id!, this.recipes[recipeId].id)
      .subscribe(data => this.recipes[recipeId].comments.push(data))
  }

  logout() {
    this.userService.loggedInUser = null;
    this.router.navigate(['login'])
  }

}
