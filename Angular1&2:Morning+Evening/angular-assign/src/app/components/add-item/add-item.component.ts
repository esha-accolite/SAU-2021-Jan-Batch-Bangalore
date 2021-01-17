import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { session_details } from '../../models/session_details';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.scss']
})
export class AddItemComponent implements OnInit {
  @Output() addSession: EventEmitter<session_details> = new EventEmitter(); 

  name:String = ""
  trainer:String = ""
  date:Date = new Date()

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){
    
    const session = {
      name: this.name,
      trainer: this.trainer,
      date: this.date
    };
    console.log(session);
    this.addSession.emit(session);
  }

}
