import { Injectable } from '@angular/core';
import { element } from 'protractor';
import { session_details } from '../models/session_details';

@Injectable({
  providedIn: 'root'
})
export class SessionDataService {

  // session: session_details = {name: "", trainer: "", date: new Date()}
  name: String = ""
  trainer: String = ""
  date: Date = new Date()

  d = [
    {
      name:'React native Session',
      trainer: 'Tajammul Pasha',
      date: new Date('2021-01-14')
    },
    {
      name:'React Session 2',
      trainer: 'Raviteja V',
      date: new Date('2021-01-13')
    },
    {
      name:'React Session 1',
      trainer: 'Vigneshwar K',
      date: new Date('2021-01-13')
    },
    {
      name:'Version Control System',
      trainer: 'Devansh',
      date: new Date('2021-01-06')
    }
  ];

  constructor() { }

  getSessionDetails(){
    return this.d;
  }

  deletesSession(session:session_details){
    this.d.forEach((element,index)=>{
      // if(element.name==session.name) delete this.d[index];
      if(element.name==session.name) this.d.splice(index,1);
    });
  }

  add(session:any){
    this.d.push({name:session.name,trainer:session.trainer,date:session.date});
  }

  edit(session:any){
    // console.log(session);
    this.add(session);
    this.deletesSession(this.d[0]);
    // this.d.push({name:session.name,trainer:session.trainer,date:session.date});
    // console.log(this.d);
    // let index = this.d.indexOf(session.name);
    // this.d[index]=session;
    // this.getSessionDetails();
    // this.d.forEach((element,index)=>{
    //   if(element.name==session.name)
    //   {
    //     // this.d[index]=session;
    //     this.d.push({name:session.name,trainer:session.trainer,date:session.date});
    //   }
    // });
  }
}
