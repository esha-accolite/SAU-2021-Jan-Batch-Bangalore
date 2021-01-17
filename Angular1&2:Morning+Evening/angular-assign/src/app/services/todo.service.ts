import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Todo } from '../models/Todo';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-type' : 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})

export class TodoService {
  todosURL = 'https://jsonplaceholder.typicode.com/todos';
  todosLimit = '?_limit=20';

  constructor(private http:HttpClient) { }

  getTodos():Observable<Todo[]>{
    return this.http.get<Todo[]>(`${this.todosURL}${this.todosLimit}`);
  }

  toggleCompleted(todo:Todo):Observable<any>{
    const url = `${this.todosURL}/${todo.id}`;
    return this.http.put(url, todo, httpOptions);
  }

  todoDisplay(todo:Todo):Observable<any>{
    return this.http.get<Todo[]>(`${this.todosURL}/${todo.id}`);
  }
}
