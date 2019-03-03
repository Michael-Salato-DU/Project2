Feature: User Experience

Background:
   Given : I am on the Home Page  
   
Scenario Outline: User Logs on successfully
   	Given : I have selected the Login button
   	When : I enter my "<username>" and "<password>"
  	Then : I am logged on
	Examples:
   	|username | password |
   	|  Goths       |   password       | 
   
Scenario Outline: User enters invalid credentials
     Given : I have selected the Login button
     When : I enter my "<username>" and "<password>"
     Then : I am not logged on   
	Examples:
     |username | password |
     |  hello       |   byebye       |   

Scenario Outline: User Registers
        Given : I have selected Register
        When : I enter my "<first name>" and "<last name>" and "<email>" and "<username>" and "<password>" and "<address>" and "<phone number>"
        Then : I successfully register
   Examples:
        | first name | last name | email | username | password | address | phone number |
        | Peter| Asaad| myemail@email.com  | peterasaad | pass  | address | 111-222-3333|
        
        
Scenario Outline: User searches for a room
     Given : I enter a "<start date>" and an "<end date>" 
     When : I click on Reserve a Room
     Then : I see a list of rooms available
   Examples:
      |start date|end date|
      | 03-01-2025         | 05-01-2025       |          



