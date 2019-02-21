
Feature: User Experience

  
  Scenario Outline: User Logs on successfully
    Given : I am on the Home Page
    When : I enter my "<username>" and "<password>"
    Then : I am logged on
    
     Examples: 
      |username | password |
      |					|					 |
    
  Scenario Outline: User enters invalid credentials
  	Given : I am on the Home Page
  	When : I enter my "<username>" and "<password>"
  	Then : I am not logged on

    Examples: 
      |username | password |
      |					|					 |
      
   Scenario Outline: User searches for a room
   		Given : I am on the Home Page
   		When : I enter a "<start date>" and an <"end date">
   		Then : I see a list of rooms available
   		
   	Examples:
   		|start date|end date|
   		|		       |        |
   		
   		
  Scenario Outline: User enters a duplicate username
  	Given : I am on the Registration Page
  	When : I enter a duplicate <"username">
  	Then : I receive a duplicate usernme error
  	
  	Examples:
  	|username|
  	|				 |
  	  	
  Scenario: User reserves a room
  	Given : I am on the Reservation Page
  	Given : A room is available
  	When : I select a room to reserve 
  	Then : It is reserved
  	
 	Scenario Outline: User Registers
 		Given : I am on the Registration Page
 		When : I enter "<first name>", <"last name">, <"email>", "<username>", "<password">, <"address">, "<phone number>"
 		Then : I successfully register
 		
 		Examples:
 		| first name | last name | email | username | password | address | phone number | 
 		|					   |		       |	     |				  |			     |			   |              |
 		
 		Scenario Outline: I need to enter payment information
 		Given : I am on the Reservation Confirmation Page
 		When : I enter my <"credit card number">, <"cvv">, <"expiration date">
 		Then : I reserve a room
   	
   	Examples: 
   	| credit card number | cvv | expiration date|
   	|										 |		 | 								|
	