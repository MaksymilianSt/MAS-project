import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CommonModule, NgForOf} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {Comment} from "../Models/Comment";


@Component({
  selector: 'app-comment',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './comment.component.html',
  styleUrl: './comment.component.css'
})
export class CommentComponent {
  @Input()
  comments: Comment[] = [];

  @Output() newCommentEmitter = new EventEmitter<string>();

  // @ts-ignore
  newCommentText:string = '';

  onAddNewUser(){
    //service current user
    this.newCommentEmitter.emit(this.newCommentText);
    this.newCommentText = '';
  }

}
