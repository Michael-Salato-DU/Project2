import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from 'src/app/components/register/register.component';
import {DateSelectionComponent} from 'src/app/components/date-selection/date-selection.component'

const routes: Routes = [
  {path : 'register', component : RegisterComponent},
  {path : 'date-selection',component : DateSelectionComponent}


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
