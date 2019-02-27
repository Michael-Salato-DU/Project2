import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-date-selection',
  templateUrl: './date-selection.component.html',
  styleUrls: ['./date-selection.component.css']
})
export class DateSelectionComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  today :Date = new Date();
  tomorrow :Date = new Date(this.today.getTime() + (1000 * 60 * 60 * 24));
  startDate :Date;
  endDate :Date;
  submitDates() {
    
  }
}
