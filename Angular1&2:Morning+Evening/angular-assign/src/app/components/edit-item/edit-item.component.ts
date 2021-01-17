import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { session_details } from '../../models/session_details';

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.scss']
})
export class EditItemComponent implements OnInit {
  @Input() session:session_details = {name:"",trainer:"",date:new Date()};
  @Input() sName:String = "";
  @Input() sTrainer:String = "";
  @Input() sDate:String = "";
  @Output() editSession: EventEmitter<session_details> = new EventEmitter();
  @Output() deleteSession: EventEmitter<session_details> = new EventEmitter();
  name:String = ""
  trainer:String = ""
  date:Date = new Date()

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){
    // console.log("edit on submit called!");
    const session = {
      name: this.name,
      trainer: this.trainer,
      date: this.date
    };
    this.editSession.emit(session);
    // this.deleteSession.emit(session);
    // console.log(session);
  }

  del(session:session_details){
    this.deleteSession.emit(session);
  }
  
}
