CREATE TABLE users (
	id			BIGINT			NOT NULL AUTO_INCREMENT,
	-- 基本カラム
	username	VARCHAR( 50)	CHARACTER SET ascii NOT NULL ,
	email		VARCHAR(255)	CHARACTER SET ascii NOT NULL ,
	password	VARCHAR(255)	CHARACTER SET ascii NOT NULL ,
	-- 登録日時 / 更新日時
	created		DATETIME		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated		DATETIME		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	-- 削除日時
	deleted		DATETIME,
	UNIQUE INDEX uid_username(username, deleted),
	UNIQUE INDEX uid_email(   email   , deleted),
	PRIMARY KEY (id)
);

