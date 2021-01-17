import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Todo } from '../../models/Todo';
import { TodoService } from '../../services/todo.service';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.scss']
})
export class TodoItemComponent implements OnInit {
  @Input() todo:Todo = {id:0,title:"",completed:false};
  @Output() deleteTodo: EventEmitter<Todo> = new EventEmitter();
  @Output() displayTodos: EventEmitter<Todo> = new EventEmitter();

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
  }

  setClasses(){
    let classes = {
      todo: true,
      'is-complete': this.todo.completed
    }
    return classes;
  }

  onToggle(todo:Todo){
    //Toggle in UI
    todo.completed = !todo.completed;
    //Toggle on server
    this.todoService.toggleCompleted(todo).subscribe(todo => {
      console.log(todo);
    })
  }

  onDelete(todo:Todo){
    console.log("deleted");
    this.deleteTodo.emit(todo);
  }

  showTodoDetails(todo:Todo){
    this.todoService.todoDisplay(todo).subscribe(todo => {
      this.displayTodos.emit(todo);
    })
  }


}
