CREATE TABLE PERSON
( 
	ID 		NUMBER PRIMARY KEY,
	NAME 	VARCHAR(30),
	CREATED timestamp,
	CONSTRAINT IDX_PERSON_ID PRIMARY KEY (ID)
);

CREATE TABLE ACCOUNT
( 
	ID 		NUMBER PRIMARY KEY,
	PERSON_ID NUMBER,
	CREATED timestamp,
	CONSTRAINT IDX_ACCOUNT_ID PRIMARY KEY (ID),
	CONSTRAINT FK_ACCOUNT_PERSON_ID FOREIGN KEY (PERSON_ID) REFERENCES PERSON(ID) on delete cascade
);

CREATE TABLE LOAN
( 
	ID 			NUMBER PRIMARY KEY,
	ACCOUNT_ID	NUMBER,
	AMOUNT 		NUMBER,
	TERM_END	DATE,
	TERM_START	DATE,
	CREATED timestamp,
	CONSTRAINT IDX_LOAN_ID PRIMARY KEY (ID),
	CONSTRAINT FK_LOAN_ACCOUNT_ID FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNT(ID) on delete cascade
);

CREATE TABLE LOAN_HISTORY
( 
	ID 			NUMBER PRIMARY KEY,
	LOAN_ID		NUMBER,
	CHANGED_DATE	DATE,
	OLD_TERM_END		DATE,
	EXTENDED_BY_WEEKS	NUMBER,
	PERSON_IP			VARCHAR(15),
	CREATED timestamp,
	CONSTRAINT IDX_LOAN_HIST_ID PRIMARY KEY (ID),
	CONSTRAINT FK_ACCOUNT_USER_ID FOREIGN KEY (LOAN_ID) REFERENCES LOAN(ID) on delete cascade
);