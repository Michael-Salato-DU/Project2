import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './components/register/register.component';
import { DateSelectionComponent } from './components/date-selection/date-selection.component';
import { RegisterService } from './services/register.service';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { ReservationComponent } from './components/reservation/reservation.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { ReservationService } from './services/reservation.service';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { CustomerHistoryComponent } from './components/customer-history/customer-history.component';


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    DateSelectionComponent,
    LoginComponent,
    ReservationComponent,
    CheckoutComponent,
    CustomerHistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [RegisterService, LoginService, ReservationService,CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
