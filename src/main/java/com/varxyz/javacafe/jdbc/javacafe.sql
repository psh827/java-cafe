CREATE TABLE LargeCategory(
	lcId 	BIGINT			PRIMARY KEY AUTO_INCREMENT,
	largeCategoryName	VARCHAR(30)		NOT NULL
)AUTO_INCREMENT 1001;

INSERT INTO LargeCategory (largeCategoryName) VALUE ("커피");
SELECT * FROM LargeCategory;
SELECT * FROM MenuItem;
SELECT * FROM Image;

DELETE FROM LargeCategory WHERE lcId = 1002;

CREATE TABLE MenuItem(
	mId 		BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	lcFk	BIGINT		NOT NULL,
	menuItemName	VARCHAR(30)	NOT NULL,
	menuPrice		INT			NOT NULL,
	ihb				CHAR(1)		NOT NULL,
	outOfStock		CHAR(1)		NOT NULL DEFAULT 'N',
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


SELECT m.menuItemName, m.menuPrice, m.ihb, m.stock, l.largeCategoryName, i.imgUrl, m.regDate FROM MenuItem m INNER JOIN Image i ON m.mId = i.menuFk
 INNER JOIN LargeCategory l ON l.lcId = m.lcFk;

DROP TABLE LargeCategory;
DROP TABLE SmallCategory;
DROP TABLE MenuItem;
DROP TABLE Image;
