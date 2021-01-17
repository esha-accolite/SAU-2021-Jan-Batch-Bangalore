import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { session_details } from 'src/app/models/session_details';

@Component({
  selector: 'app-session-item',
  templateUrl: './session-item.component.html',
  styleUrls: ['./session-item.component.scss']
})
export class SessionItemComponent implements OnInit {
  @Input() session:session_details = {name:"",trainer:"",date:new Date()};
  @Output() displayDetails: EventEmitter<session_details> = new EventEmitter();
  @Output() deleteSession: EventEmitter<session_details> = new EventEmitter();
  @Output() editSession: EventEmitter<session_details> = new EventEmitter();
  @Output() displaySession: EventEmitter<session_details> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  showSessionDetails(session:session_details){
    console.log("details displayed!");
    this.displayDetails.emit(session);
  }

  onDelete(session:session_details){
    console.log("session deleted!");
    this.deleteSession.emit(session);
  }

  onEdit(session:session_details){
    console.log("session edit!");
    this.displaySession.emit(session);
    this.editSession.emit(session);
    // this.del(session);
    // this.deleteSession.emit(session);
  }

  // del(session:session_details){
  //   this.deleteSession.emit(session);
  // }
}
