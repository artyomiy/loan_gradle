Feature: Getting loan

	Scenario Outline: A User can apply for a loan by selecting amount and term and then clicking the „Apply” button 
				if submitted time between 06:00 am and 00:00
					and not selected the maximum possible amount
					and the number of applications made from a single IP within a single day has reached 3 applications.

		Given a user has no loan 
		When user applied for loan <loan> and term <term> month
			And application submitted not between <time from> and <time till> 
			And not selected the max amount
			And number of applications from a single IP within a day is less then 3		
		Then users loan balance should be <loan> 
			And term date <term> 
		
		Examples:
		    | loan | term | time from | time till |
		    | 100  | 3	  | 00:00  	  | 06:00	  |
	    
	    
	Scenario Outline: On "My Loans" page the client should be able to extend a loan by clicking "Extend" button. 
	
		Given user has a loan in his account
		When user extend a loan
		Then term of the loan extended by <week amount> 
			And interest increased by <interest> factor

		Examples:
		    | week amount | interest |
		    | 1  		  | 1.5	     |