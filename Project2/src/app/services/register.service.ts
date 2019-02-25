// import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
// import { HttpHeaders } from '@angular/common/http';
import { Customer } from 'src/app/models/Customer';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  //this url will be the .do
  registerUrl :string  = "http://ec2-52-15-141-97.us-east-2.compute.amazonaws.com:8080/Project2/register.do";
  "http://ec2-52-15-141-97.us-east-2.compute.amazonaws.com:8080/Project2/register.do?first_name= fname&last_name= lname&username= uname&password= psw&email= email&phone= phone&address= address"

  constructor(private http :HttpClient) { }
  
  sendRegister(customer :Customer):any{
    return this.http.post(this.registerUrl + "?first_name ="+customer.first_name +"&last_name=" + customer.last_name, + "&username="+customer.username + "&password="+customer.password + "&email=" + customer.email +"&phone_number="+customer.phone_number + "&address="+customer.address);
  }
  
}
