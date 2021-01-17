import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TodosComponent } from './components/todos/todos.component';
import { EditItemComponent } from './components/edit-item/edit-item.component';

const routes: Routes = [
  { path: 'todos', component: TodosComponent },
  { path: 'edit', component: EditItemComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
