CREATE TABLE user_infos (
	user_id     BIGINT NOT NULL,
	-- 基本カラム
	first_name	VARCHAR( 50),
	middle_name	VARCHAR( 50),
	last_name	VARCHAR( 50),
	disp_name	VARCHAR( 50) NOT NULL,
	-- 登録日時 / 更新日時
	created		DATETIME		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated		DATETIME		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	-- 削除日時
	deleted		DATETIME,
	PRIMARY KEY (user_id)
);

