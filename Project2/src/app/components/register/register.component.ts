import { Component, OnInit } from '@angular/core';
import { RegisterService } from 'src/app/services/register.service';
import { Customer } from 'src/app/models/Customer';


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
  email :string;
  phone_number :string;
  address :string;
  register(){
    // console.log((<HTMLSelectElement>document.getElementById('first_name')).value);
    this.first_name = (<HTMLSelectElement>document.getElementById('first_name')).value;
    console.log(this.first_name);
    this.newCustomer.first_name = this.first_name;
    this.last_name  = (<HTMLSelectElement>document.getElementById('last_name')).value;
    this.username = (<HTMLSelectElement>document.getElementById('username')).value;
    this.password = (<HTMLSelectElement>document.getElementById('rpsw')).value;
    this.email = (<HTMLSelectElement>document.getElementById('email')).value;
    this.phone_number = (<HTMLSelectElement>document.getElementById('phone_number')).value;
    this.address = (<HTMLSelectElement>document.getElementById('address')).value;
    this.newCustomer = new Customer(0,this.first_name, this.last_name, this.username, this.password,this.email, this.phone_number, this.address);
    console.log(this.newCustomer);
    // this.rs.sendRegister(this.newCustomer);
  }

}
