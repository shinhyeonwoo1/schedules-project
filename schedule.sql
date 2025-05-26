
CREATE TABLE member
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '멤버 식별자',
    email    VARCHAR(20)  NOT NULL COMMENT '이메일',
    username varchar(20)  NOT NULL COMMENT '이름',
    jop  varchar(100) NOT NULL COMMENT '직업'
);


CREATE TABLE schedule
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '스케쥴 식별자',
    title       VARCHAR(20)   COMMENT '할일 제목',
    username    VARCHAR(20)   COMMENT '작성자',
    content     VARCHAR(100)  COMMENT '할일 내용 ',
    create_date DATETIME      COMMENT '작성일',
    modify_date DATETIME      COMMENT '수정일'

);


CREATE TABLE enrollment
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '등록 식별자',
    schedule_id BIGINT COMMENT '스케쥴 식별',
    member_id   BIGINT COMMENT '멤버 식별자',
    FOREIGN KEY (schedule_id) REFERENCES schedule (id),
    FOREIGN KEY (member_id) REFERENCES member (id)
);
