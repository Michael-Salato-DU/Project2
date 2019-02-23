import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DateSelectionComponent} from 'src/app/components/date-selection/date-selection.component'

const routes: Routes = [
  {path : 'date-selection',component : DateSelectionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
