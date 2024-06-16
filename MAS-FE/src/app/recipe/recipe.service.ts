import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Recipe} from "../Models/Recipe";

import {Observable} from "rxjs";
import {Comment} from "../Models/Comment";

@Injectable({providedIn: 'root'})
export class RecipeService {

  constructor(private httpClient: HttpClient) {

  }

  fetchAllRecipes():Observable<Recipe[]> {
    console.log('fetchyng')
    return this.httpClient.get<Recipe[]>("http://localhost:8080/recipe");
  }

  addComment(text: string, userId: number, recipeId: number){

    return this.httpClient.post<Comment>("http://localhost:8080/user/"+ userId + "/" + "recipe/" + recipeId + "/comment", text);
  }

}
