import { Component, Input, OnInit } from '@angular/core';
import { session_details } from '../../models/session_details';
import { SessionDataService } from '../../services/session-data.service';

@Component({
  selector: 'app-session-list',
  templateUrl: './session-list.component.html',
  styleUrls: ['./session-list.component.scss']
})
export class SessionListComponent implements OnInit {
  @Input() session:session_details = {name:"",trainer:"",date:new Date()};
  sessions:session_details[] = [];
  sessionName:String = "";
  sessionTrainer:String = "";
  sessionDate:Date = new Date();
  sName:String = "";
  sTrainer:String = "";
  sDate:Date = new Date(); 


  constructor(private sessionService:SessionDataService) { 
  }

  ngOnInit(): void {
    this.sessions = this.sessionService.getSessionDetails();
    // this.sessions = [
    //   {
    //     name:'React native Session',
    //     trainer: 'Tajammul Pasha',
    //     date: new Date('2021-01-14')
    //   },
    //   {
    //     name:'React Session 2',
    //     trainer: 'Raviteja V',
    //     date: new Date('2021-01-13')
    //   },
    //   {
    //     name:'React Session 1',
    //     trainer: 'Vigneshwar K',
    //     date: new Date('2021-01-13')
    //   },
    //   {
    //     name:'Version Control System',
    //     trainer: 'Devansh',
    //     date: new Date('2021-01-06')
    //   }
    // ];

  }

  displayDetails(session:session_details){
    console.log("details here!");
    this.sessionName = session.name;
    this.sessionTrainer = session.trainer;
    this.sessionDate = session.date;  
  }

  deleteSession(session:session_details){
    console.log("session deleted successfully!");
    this.sessionService.deletesSession(session);
    this.sessions = this.sessions.filter(s => s.name!=session.name);
  }

  addSession(session:session_details){
    this.sessionService.add(session);
  }

  editSession(session:session_details){
    // console.log(session);
    this.sessionService.edit(session);
  }

  displaySession(session:session_details){
    // console.log("details here!");
    this.sName = session.name;
    this.sTrainer = session.trainer;
    this.sDate = session.date;  
  }

}
