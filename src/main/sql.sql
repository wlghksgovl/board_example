CREATE TABLE board(
	u_num		INT		PRIMARY KEY AUTO_INCREMENT,
    u_name		CHAR(20)	NOT NULL,
    u_pw		CHAR(20)	NOT NULL,
    u_contents	CHAR(200)	NOT NULL
);
DROP TABLE board;
SELECT * FROM board;

SET @rownum:=0;
SELECT @rownum:=@rownum+1 u_num FROM `index`.board;

SET @rownum:=0;
user.page=SELECT * FROM board  ORDER BY u_num DESC LIMIT 0, 5;
select count(*) cnt from board;