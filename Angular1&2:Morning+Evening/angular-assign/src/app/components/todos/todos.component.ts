import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap} from '@angular/router';
import { Todo } from '../../models/Todo';
import { TodoService } from '../../services/todo.service';


@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.scss']
})
export class TodosComponent implements OnInit {
  todos:Todo[] = [];
  todoId:number = 0;
  todoTitle:String = "";
  todoComplete:Boolean = false;

  constructor(private todoService:TodoService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.todoService.getTodos().subscribe(todos => {
      this.todos = todos;
    })
  }

  deleteTodo(todo:Todo){
    this.todos = this.todos.filter(t => t.id!=todo.id);
  }

  displayTodos(todo:Todo){
    console.log("todo details here!");
    this.todoId = todo.id;
    this.todoTitle = todo.title;
    this.todoComplete = todo.completed;  
  }

}
