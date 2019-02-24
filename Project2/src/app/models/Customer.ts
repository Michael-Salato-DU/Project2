export class Customer{
    id :number;
    first_name :string;
    last_name :string;
    username :string;
    password :string;
    email :string;
    phone_number :string;
    address :string;
    constructor(id :number, first_name :string, last_name :string, username :string, password :string, email :string, phone_number :string, address :string){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.phone_number = phone_number;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
    }
}