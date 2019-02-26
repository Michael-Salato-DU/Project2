import { Component, OnInit } from '@angular/core';
import { RegisterService } from 'src/app/services/register.service';
import { Customer } from 'src/app/models/Customer';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private rs: RegisterService) { }

  ngOnInit() {

  }

  newCustomer :Customer;
  first_name :string;
  last_name :string;
  username :string;
  password :string;
  rpsw :string;
  email :string;
  phone_number :string;
  address :string;

  registerResponse :Observable<string>;

  register(){
    this.newCustomer = new Customer(0,this.first_name, this.last_name, this.username, this.password,this.email, this.phone_number, this.address);
    console.log(this.newCustomer);
    this.rs.sendRegister(this.newCustomer).subscribe((response)=>{console.log("success: " + response.toString())},(response)=>{console.log("failure: " +response.toString())});
  }

}
