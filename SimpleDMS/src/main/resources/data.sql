-- Todo:자주묻는질문 테이블

-- INSERT INTO TB_FAQ
-- VALUES (SQ_FAQ.nextval, '이 사이트는 어떻게 제작되었나요?',
--         '저희 사이트는 Vue.js와 Springboot를 이용하여 제작되었으며 bootstrap5를 적용하여 반응형 웹사이트로 구현되었습니다.', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAQ
-- VALUES (SQ_FAQ.nextval, '회원정보는 어떻게 저장되나요?', '저희회원정보는 어떻게 저장되나 사이트는 jwt토큰 방식을 사용한 로그인 방식으로 안전하게 저장 및 보관됩니다.', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAQ
-- VALUES (SQ_FAQ.nextval, '회원만 사이트를 이용할 수 있나요?', '비회원으로도 사이트 대부분의 기능을 이용가능하지만 로그인 시 다양한 개인 맞춤형 서비스 제공이 가능합니다.', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAQ
-- VALUES (SQ_FAQ.nextval, '질문이 없으면 어떡하죠?', '저도 빈칸 채우기가 힘들어서 굳이 질문안하셔도 됩니다.', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

-- Todo:질문 테이블
-- INSERT INTO TB_QUESTION
-- VALUES (SQ_QUESTION.nextval, '질문', '내용', 1, 0, 'forbob', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_QUESTION
-- VALUES (SQ_QUESTION.nextval, '질문2', '내용2', 2, 0, 'JANGDH', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_QUESTION
-- VALUES (SQ_QUESTION.nextval, '질문3', '내용3', 3, 0, 'JOSM', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_QUESTION
-- VALUES (SQ_QUESTION.nextval, '질문4', '내용4', 4, 0, 'JUNSH', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_QUESTION
-- VALUES (SQ_QUESTION.nextval, '질문5', '내용5', 5, 0, 'KWONTH', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_QUESTION
-- VALUES (SQ_QUESTION.nextval, '질문6', '내용6', 6, 0, 'PARKSY', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

-- Todo:댓글 테이블 세분화
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 1, 0, 0, 0, 1, 'forbob', '사이트에 에러가 너무 많아요 어떻하죠', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 0, 1, 0, 0, 1, 'forbob', '답변122222222222222', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 1, 0, 0, 0, 2, 'JANGDH', '버전2는 얼마나 업그레이드 되나요?', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 0, 0, 2, 0, 2, 'JANGDH', '답변22222222222', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 0, 0, 0, 1, 3, 'JOSM', '버전은 몇까지 나오나요?', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 0, 1, 0, 0, 3, 'JOSM', '답변333333333', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 4, 0, 0, 0, 4, 'JUNSH','버전2에서는 예약기능이 잘 작동할까요?', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 0, 0, 0, 3, 4, 'JUNSH','답변44444444444', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 0, 2, 0, 0, 5, 'KWONTH', '버전2에서는 게시판을 좀더 예쁘게 만들고 깊어요', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 3, 0, 0, 0, 5, 'KWONTH', '답변5555555555', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 2, 0, 0, 0, 6, 'PARKSY','답변666666666', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_COMMENT
-- VALUES (SQ_COMMENT.nextval, 0, 0, 0, 2, 6, 'PARKSY','답변6666666666', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


-- Todo:공지사항 테이블
-- INSERT INTO TB_ANNOUNCE
-- VALUES (SQ_ANNOUNCE.nextval, '사이트 이용 규칙에 대해', '타인을 비방하는 게시글은 관리자를 통해 삭제될 수 있습니다.', '관리자', 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_ANNOUNCE
-- VALUES (SQ_ANNOUNCE.nextval, '음식점 정보에 관해', '사실과 다른 내용이 기재될 경우 통보없이 삭제될 수 있습니다.', '관리자', 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_ANNOUNCE
-- VALUES (SQ_ANNOUNCE.nextval, '회원정보 관리에 대해', 'ㅊ.', '관리자', 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_ANNOUNCE
-- VALUES (SQ_ANNOUNCE.nextval, '이용약관에 대해', 'ㅊ.', '관리자', 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_ANNOUNCE
-- VALUES (SQ_ANNOUNCE.nextval, 'ㅊ', '5명이서 협업해서 제작한 사이트로 Vue.js와 Springboot를 이용해서 작업했습니다.', '관리자', 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_ANNOUNCE
-- VALUES (SQ_ANNOUNCE.nextval, '질문사항에 대해', '질문게시판을 이용해주세요.', '관리자', 0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),
--         NULL,
--         NULL);

-- Todo:푸드컬럼 테이블
-- INSERT INTO TB_COLUMN
-- VALUES (SQ_COLUMN.nextval, '1', '강태경', '연말연시 맛집 추천', '2023년을 맞이하여', '대충 내용있음', '', '', '', '', 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
--         NULL, NULL);
-- INSERT INTO TB_COLUMN
-- VALUES (SQ_COLUMN.nextval, '2', '장동혁', '서면 맛집 Best5', '부산토박이가 알려주는 로컬맛집', '대충 내용있음', '', '', '', '', 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
--         NULL, NULL);
-- INSERT INTO TB_COLUMN
-- VALUES (SQ_COLUMN.nextval, '3', '조성모', '여기가 바로 가성비 맛집', '서비스는 필요없다. 오로지 가성비로만 승부', '대충 내용있음', '', '', '', '', 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
--         NULL, NULL);



-- Todo:예약 테이블
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '장동혁', '3', '010-1234-5678', '1', '2', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '장동혁', '2', '010-1234-5678', '2', '2', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '장동혁', '4', '010-1234-5678', '3', '2', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '장동혁', '2', '010-1234-5678', '4', '2', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '장동혁', '2', '010-1234-5678', '5', '2', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '조성모', '3', '010-1234-5678', '6', '3', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '조성모', '2', '010-1234-5678', '7', '3', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '조성모', '4', '010-1234-5678', '8', '3', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '조성모', '2', '010-1234-5678', '9', '3', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '전성혜', '2', '010-1234-5678', '10', '4', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '전성혜', '3', '010-1234-5678', '11', '4', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '전성혜', '2', '010-1234-5678', '12', '4', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '전성혜', '4', '010-1234-5678', '13', '4', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '권태현', '2', '010-1234-5678', '14', '5', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '권태현', '2', '010-1234-5678', '15', '5', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_RESERVATION
-- VALUES (SQ_RESERVATION.nextval, '박선영', '3', '010-1234-5678', '16', '6', '2022-12-24', '18:30', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


-- Todo:음식점 테이블
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '해목', 0, '부산광역시 해운대구 구남로24번길 8', '0507-1385-3730', '일식', '데이트',
        'https://mp-seoul-image-production-s3.mangoplate.com/1129699_1620482534399327.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/2417783_1671374230283185.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/2417783_1671374233187333.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/2215830_1669806572053505.jpg', 35.161820360403,
        129.159655134617, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '합천국밥집', 0, '부산광역시 남구 용호로 235', '051-628-4898', '한식', '데이트',
        'https://mp-seoul-image-production-s3.mangoplate.com/25551/j7nkzmgyxpmqqa.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/25551/j7nkzmgyxpmqqa.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/766789_1668128508465239.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/702118_1665327887509061.jpg', 35.1112444649127,
        129.111258148054, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '톤쇼우', 0, '부산 금정구 금강로 247-10', '051-517-1727', '중식', '데이트',
        'https://mp-seoul-image-production-s3.mangoplate.com/872186_1608730709406579.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/879773_1665405192251274.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/879773_1665405194492887.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/879773_1665405197922756.jpg', 35.2304471534003,
        129.084270106003, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '미청식당', 0, '부산광역시 기장군 일광읍 기장해안로 1303', '051-721-7050', '한식', '모임',
        'https://mp-seoul-image-production-s3.mangoplate.com/1049578_1634728853479974.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/1049578_1634728853479974.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/535867_1664516256117723.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/1704015_1664099356134179.jpg', 35.2602690925274,
        129.233171640935, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '백객도', 0, '부산광역시 동래구 금정마을로 70', '051-554-5873', '중식', '모임',
        'https://mp-seoul-image-production-s3.mangoplate.com/1515134_1669012125992684.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/1515134_1669012125992684.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/27597_1533041714270546.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/1991439_1640211250299117.jpg', 35.2123357196656,
        129.063469116458, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '디젤앤카멜리아스', 0, '부산 해운대구 우동1로20번길 11', '010-9179-6960', '일식', '회식',
        'https://mp-seoul-image-production-s3.mangoplate.com/586167_1609749120642980.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/586167_1609749120642980.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/584169_1627451236137740.jpg',
        'https://mp-seoul-image-production-s3.mangoplate.com/426722/451499_1667185618212_1000000423', 35.1639816443536,
        129.157214149098, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '옥천횟집', 0, '부산 영도구 중리남로 2-21', '051-403-7771', '한식', '데이트',
        'https://mp-seoul-image-production-s3.mangoplate.com/693574_1667123439355703.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/693574_1667123437445455.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/433821/1248917_1664576600469_12495?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/291910_1658382078702944.jpg', 35.0677629879774,
        129.065989160108, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '다온나루', 0, '부산 강서구 범방3로46번길 21', '051-832-1771', '중식', '데이트',
        'https://mp-seoul-image-production-s3.mangoplate.com/393053/2032908_1653224070853_50338?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/393053/2032908_1628770504437_37278',
        'https://mp-seoul-image-production-s3.mangoplate.com/393053/2032908_1653224070853_50648?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/393053/2032835_1628744146510_5900', 35.1464805237631,
        128.882125351713, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '금수복국', 0, '부산 해운대구 중동1로43번길 23', '051-742-3600', '양식', '식사',
        'https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/584169_1492330956578913.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/236197_1458602856922119.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/584169_1492330957403742.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/17153/1466243_1670836141500_17327', 35.1624170972637,
        129.164490214477, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '초원복국', 0, '부산 남구 황령대로492번길 30', '051-628-3935', '한식', '식사',
        'https://mp-seoul-image-production-s3.mangoplate.com/546909_1536072584565408.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/546909_1536072584565408.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/25506/1354267_1670127712759_1000003821?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/1704015_1630808810719524.jpg', 35.1377732980978,
        129.105897235154, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '양자강', 0, '부산 금정구 금단로 191', '051-583-1266', '중식', '모임',
        'https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/9388_1480730005476394.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/24550/20130825_76/byunjh8_1377432985620f3l0i_jpeg/img_5792.jpg',
        'https://mp-seoul-image-production-s3.mangoplate.com/1515134_1646373249866917.jpg',
        'https://mp-seoul-image-production-s3.mangoplate.com/1515134_1646373250201923.jpg', 35.2658694047534,
        129.093514580494, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '일광대복집', 0, '부산 기장군 일광읍 이화로 3', '051-721-1561', '한식', '회식',
        'https://mp-seoul-image-production-s3.mangoplate.com/147811_1633838192987199.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/147811_1633838192987199.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/147811_1633838195008126.jpg',
        'https://mp-seoul-image-production-s3.mangoplate.com/147811_1654517342330242.jpg', 35.2669709895718,
        129.23351097849, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '오노고로', 0, '부산 동래구 명륜로 150 1층', '0507-1347-2015', '중식', '데이트',
        'https://mp-seoul-image-production-s3.mangoplate.com/693546_1670850112205255.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/693546_1670850112205255.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/693546_1669123034950658.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/468455/2392178_1665447038012_75572', 35.2071080616634,
        129.082162483988, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '로바타아키', 0, '부산 부산진구 동천로85번길 8', '0507-1322-3415', '양식', '모임',
        'https://mp-seoul-image-production-s3.mangoplate.com/1042441_1605430643484440.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/1042441_1605430643484440.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/406821/571675_1619327529261_44532',
        'https://mp-seoul-image-production-s3.mangoplate.com/406821/571675_1619327529261_44550', 35.1564081607434,
        129.061875359282, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '일구향만두', 0, '부산 영도구 절영로49번길 24', '051-418-7285', '한식', '데이트',
        'https://mp-seoul-image-production-s3.mangoplate.com/348107/1466243_1670838071029_17000?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/348107/1466243_1670838071029_17000?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/20218_1666076504028681.jpg',
        'https://mp-seoul-image-production-s3.mangoplate.com/348107/37208_1525199727913_44973', 35.0895158854129,
        129.039721514353, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '대저할매국수', 0, '부산 강서구 대저중앙로 337', '051-973-0837', '한식', '회식',
        'https://mp-seoul-image-production-s3.mangoplate.com/16929/reviews/bc862256e507.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/16929/reviews/bc862256e507.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/16929/1178180_1662277845909_9357?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',
        'https://mp-seoul-image-production-s3.mangoplate.com/2138647_1650609768588841.jpg', 35.2213257515501,
        128.983687939244, 0, 0, '메뉴1', 10000, '메뉴2', 20000, '메뉴3', 30000, '메뉴4', 40000, '메뉴5', 50000, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


-- Todo:리뷰 테이블 // ID / DNO 순서
-- INSERT INTO TB_REVIEW
-- VALUES (SQ_REVIEW.nextval, 1, 1, '유저1번', '리뷰내용', 1, 2, 3, 4, 5, 'male', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_REVIEW
-- VALUES (SQ_REVIEW.nextval, 2, 1, '유저2번', '리뷰내용', 1, 2, 3, 4, 5, 'male', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_REVIEW
-- VALUES (SQ_REVIEW.nextval, 3, 1, '유저3번', '리뷰내용', 1, 2, 3, 4, 5, 'male', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_REVIEW
-- VALUES (SQ_REVIEW.nextval, 4, 2, '유저4번', '리뷰내용', 1, 3, 3, 4, 5, 'male', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_REVIEW
-- VALUES (SQ_REVIEW.nextval, 5, 1, '유저5번', '리뷰내용', 1, 2, 3, 4, 5, 'male', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
--
--



-- Todo:자유게시판 테이블
-- INSERT INTO TB_FREE
-- VALUES (SQ_FREE.nextval, '수업이 어렵나요?', '모두들 표정이 왜그래요', '강태경', 1, 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
-- INSERT INTO TB_FREE
-- VALUES (SQ_FREE.nextval, '코로나 확진이 되었어요', '솔직히 걸릴 줄 몰랐는데 막상 걸리니까 힘들고 아프네요', '장동혁', 2, 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
--         NULL, NULL);
-- INSERT INTO TB_FREE
-- VALUES (SQ_FREE.nextval, '팀프로젝트 하는데 조장이 탈주했어요', '갑자기 코로나 걸렸다고 사라졌어요 어떡하죠', '조성모', 3, 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
--         NULL, NULL);
-- INSERT INTO TB_FREE
-- VALUES (SQ_FREE.nextval, '고양이가 너무 귀여워요', '제 고양이들 봐주세요', '전성혜', 4, 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
--         NULL, NULL);
-- INSERT INTO TB_FREE
-- VALUES (SQ_FREE.nextval, '이번 4090 그래픽카드 어떤가요', '가격이 너무 비싸서 고민되요', '권태현', 5, 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
--         NULL, NULL);
-- INSERT INTO TB_FREE
-- VALUES (SQ_FREE.nextval, '겨울에 듣기 좋은 노래 추천해주세요', '추운날씨에 듣기 좋은 곡이 있을까요', '박선영', 6, 0, 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
--         NULL, NULL);




-- Todo:찜한 음식점 테이블
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 1, 4, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 1, 3, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 1, 2, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 1, 8, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 2, 8, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 2, 1, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 2, 5, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 2, 3, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 3, 10, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 3, 1, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 3, 9, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_FAVORITE
-- VALUES (SQ_FAVORITE.nextval, 3, 4, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


-- Todo: 최근본 음식점 테이블 // 여기서 샘플 데이터 집어넣으면 같은 시간대로 insert되서 시간순 정렬이 안먹힘
-- INSERT INTO TB_LASTVIEW
-- VALUES (SQ_LASTVIEW.nextval, 1, 4, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_LASTVIEW
-- VALUES (SQ_LASTVIEW.nextval, 1, 3, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_LASTVIEW
-- VALUES (SQ_LASTVIEW.nextval, 1, 2, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_LASTVIEW
-- VALUES (SQ_LASTVIEW.nextval, 2, 1, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_LASTVIEW
-- VALUES (SQ_LASTVIEW.nextval, 2, 5, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_LASTVIEW
-- VALUES (SQ_LASTVIEW.nextval, 3, 4, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_LASTVIEW
-- VALUES (SQ_LASTVIEW.nextval, 3, 2, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


-- TODO: login 샘플 데이터
INSERT INTO TB_ROLE
VALUES (SQ_ROLE.NEXTVAL, 'ROLE_USER', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_ROLE(id, name) VALUES(SQ_ROLE.NEXTVAL, 'ROLE_MODERATOR');
INSERT INTO TB_ROLE
VALUES (SQ_ROLE.NEXTVAL, 'ROLE_ADMIN', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

-- admin user 1명 최초 생성
-- id : forbob
-- password : 123456
-- email : forbob@naver.com
-- roles : ROLE_ADMIN

INSERT INTO TB_USER
VALUES (SQ_USER.NEXTVAL, 'admin', 'tomato@admin.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6',
        '관리자', '', '', '', '', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_USER
-- VALUES (SQ_USER.NEXTVAL, 'JANGDH', 'JANG@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6',
--         '장동혁', '1992.02.02', 'male', '010-2020-0202', '부산시 영도구 남항동 123가', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_USER
-- VALUES (SQ_USER.NEXTVAL, 'JOSM', 'JO@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6', '조성모',
--         '1993.03.03', 'male', '010-2020-0202', '부산시 영도구 남항동 123가', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL,
--         NULL);
-- INSERT INTO TB_USER
-- VALUES (SQ_USER.NEXTVAL, 'JUNSH', 'JUN@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6',
--         '전성혜', '1993.03.03', 'female', '010-2020-0202', '서울특별시 종로구 팔판길 1-6', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_USER
-- VALUES (SQ_USER.NEXTVAL, 'KWONTH', 'KWON@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6',
--         '권태현', '1993.03.03', 'male', '010-2020-0202', '서울특별시 종로구 팔판길 1-6', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
-- INSERT INTO TB_USER
-- VALUES (SQ_USER.NEXTVAL, 'PARKSY', 'PARK@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6',
--         '박선영', '1993.03.03', 'female', '010-2020-0202', '서울특별시 종로구 팔판길 1-6', 'N',
--         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
--

-- TODO: (첫번째 : 유저id(시퀀스), 두번째 : 1(일반유저) 2(관리자) )
INSERT INTO TB_USER_ROLE
VALUES (1, 2);

COMMIT;