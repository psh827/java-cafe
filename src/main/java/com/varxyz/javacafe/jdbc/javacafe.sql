CREATE TABLE LargeCategory(
	lcId 	BIGINT			PRIMARY KEY AUTO_INCREMENT,
	largeCategoryName	VARCHAR(30)		NOT NULL
)AUTO_INCREMENT 1001;

INSERT INTO LargeCategory (largeCategoryName) VALUE ("커피");
SELECT * FROM LargeCategory;
SELECT * FROM MenuItem;
SELECT * FROM Image;
SELECT * FROM Cart;

DELETE FROM LargeCategory WHERE lcId = 1002;

CREATE TABLE MenuItem(
	mId 		BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	lcFk	BIGINT		NOT NULL,
	menuItemName	VARCHAR(30)	NOT NULL,
	menuPrice		INT			NOT NULL,
	ihb				VARCHAR(10)		NOT NULL,
	outOfStock		CHAR(1)		NOT NULL DEFAULT 'N',
	description 	VARCHAR(500)	NOT NULL,
	regDate 		TIMESTAMP 	NOT NULL DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT MenuItem_lcFk_FK FOREIGN KEY (lcFk) REFERENCES LargeCategory(lcId)
)AUTO_INCREMENT 2001;



CREATE TABLE Image(
	imgId BIGINT PRIMARY KEY AUTO_INCREMENT,
	menuFk	BIGINT NOT NULL,
	imgName VARCHAR(200)	NOT NULL,
	imgOriName	VARCHAR(300)	NOT NULL,
	imgUrl VARCHAR(500)		NOT NULL,
	
	CONSTRAINT Image_menuFk_FK FOREIGN KEY (menuFk) REFERENCES MenuItem(mId)
)AUTO_INCREMENT 3001;


CREATE TABLE Cart(
	cId BIGINT PRIMARY KEY AUTO_INCREMENT,
	menuItemName	VARCHAR(30) 	NOT NULL,
	ihb				VARCHAR(5)		NOT NULL,
	menuPrice		INT 		NOT NULL,
	imgName			VARCHAR(500)	NOT NULL,
	buyCount		INT			NOT NULL
)

SELECT  m.menuItemName, m.menuPrice, m.ihb, m.description FROM MenuItem m 
INNER JOIN Image i ON m.mId = i.menuFk WHERE i.imgName= '386ab4807df14806886b2adce3c68e04.jpg';

SELECT m.menuItemName, m.menuPrice, m.ihb, m.stock, l.largeCategoryName, i.imgUrl, m.regDate FROM MenuItem m INNER JOIN Image i ON m.mId = i.menuFk
 INNER JOIN LargeCategory l ON l.lcId = m.lcFk;

DROP TABLE LargeCategory;
DROP TABLE Cart;
DROP TABLE MenuItem;
DROP TABLE Image;

ALTER TABLE Cart CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
