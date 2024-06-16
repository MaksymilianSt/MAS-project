import {AppUser} from "./AppUser";
import {Ingredient} from "./Ingredient";
import {Comment} from "./Comment";

export class Recipe {

  constructor(
    public id: number,
    public user: AppUser,
    public name: String,
    public description: string,
    public difficultyLvl: number,
    public timeToPrepareInMin: number,
    public ingredients: Ingredient[],
    public comments: Comment[]
  ) {
  }

}
