Feature: Getting loan

	Scenario Outline: A User can apply for a loan by selecting amount and term and then clicking the „Apply” button 
				if submitted time between 06:00 am and 00:00
					and not selected the maximum possible amount
					and the number of applications made from a single IP within a single day has reached 3 applications.

	Given a user has no applications 
	When user applied for loan <loan> and term <term> month
		And application submitted between <accepted time from> and <accepted time till>
		And not selected the max amount
		And number of applications from a single IP within a day is less then 3		
	Then users loan balance should be <loan> 
		And term date <term> 
	
	Examples:
	    | loan | term | accepted time from | accepted time till	|
	    | 100  | 3	  | 06:00:00		   | 23:59:59 			|