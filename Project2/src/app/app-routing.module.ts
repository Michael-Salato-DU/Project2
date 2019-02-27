import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from 'src/app/components/register/register.component';
import { DateSelectionComponent } from 'src/app/components/date-selection/date-selection.component';
import { HttpClientModule} from '@angular/common/http';
import { LoginComponent } from 'src/app/components/login/login.component';
import { ReservationComponent } from './components/reservation/reservation.component';
import { CheckoutComponent } from './components/checkout/checkout.component';


const routes: Routes = [
  {path : 'register', component : RegisterComponent},
  {path : 'date-selection', component : DateSelectionComponent},
  {path : 'login', component : LoginComponent},
  {path : 'reservation', component : ReservationComponent},
  {path : 'checkout', component : CheckoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
            HttpClientModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
