CREATE TABLE LargeCategory(
	lcId 	BIGINT			PRIMARY KEY AUTO_INCREMENT,
	largeCategoryName	VARCHAR(30)		NOT NULL
)AUTO_INCREMENT 1001;

CREATE TABLE SmallCategory(
	scId		BIGINT		PRIMARY KEY AUTO_INCREMENT,
	lcFk		BIGINT 		NOT NULL,
	smallCategoryName	VARCHAR(30)	NOT NULL,
	
	CONSTRAINT SmallCategory_lcFk_FK FOREIGN KEY (lcFk) REFERENCES LargeCategory(lcId)
)AUTO_INCREMENT 2001;

SELECT * FROM MenuItem;

CREATE TABLE MenuItem(
	mId 		BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	scFk	BIGINT		NOT NULL,
	image 	LONGBLOB,
	menuItemName	VARCHAR(30)	NOT NULL,
	menuPrice		INT			NOT NULL,
	ihb				CHAR(1)		NOT NULL,
	stock			INT			NOT NULL,
	regDate 		TIMESTAMP 	NOT NULL DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT MenuItem_scFk_FK FOREIGN KEY (scFk) REFERENCES SmallCategory(scId)
)AUTO_INCREMENT 3001;

DROP TABLE LargeCategory;
DROP TABLE SmallCategory;
DROP TABLE MenuItem;
