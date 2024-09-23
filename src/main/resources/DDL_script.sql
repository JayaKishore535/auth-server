CREATE TABLE esavari.UserReg(
	UserId varchar(8) NOT NULL,
	FirstName varchar(50) NOT NULL,
	LastName varchar(50) NULL,
	UserType varchar(10) NULL,
	Emailid varchar(50) NULL,
	Mobile varchar(50) NOT NULL,
	Passwd varchar(250) NULL,
	Active varchar(1) NOT NULL,
	AdminFlag varchar(1) NOT NULL,
	UserMod varchar(100) NULL,
	CreatedBy varchar(50) NOT NULL,
	CreatedDate datetime NULL,
	ProfileImageName varchar(300) NULL,
	MgrName varchar(255) NULL,
	AdrLine1 varchar(255) NULL,
	AdrLine2 varchar(255) NULL,
	City varchar(255) NULL,
	State varchar(255) NULL,
	PinCode varchar(6) NULL,
	Remarks varchar(255) NULL,
	UpdatedBy varchar(100) NULL,
	UpdatedDate datetime NULL,
	Lat varchar(255) NULL,
	lng varchar(255) NULL,
 PRIMARY KEY
(
	UserId ASC,
	Mobile ASC
));

