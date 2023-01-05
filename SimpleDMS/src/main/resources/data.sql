-- Todo:자주묻는질문 테이블

INSERT INTO TB_FAQ
VALUES (SQ_FAQ.nextval, '이 사이트는 어떻게 제작되었나요?',
        '저희 사이트는 Vue.js와 Springboot를 이용하여 제작되었으며 bootstrap5를 적용하여 반응형 웹사이트로 구현되었습니다.', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAQ
VALUES (SQ_FAQ.nextval, '회원정보는 어떻게 저장되나요?', '저희 사이트는 jwt토큰 방식을 사용한 로그인 방식으로 안전하게 저장 및 보관됩니다.', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAQ
VALUES (SQ_FAQ.nextval, '회원만 사이트를 이용할 수 있나요?', '비회원으로도 사이트 대부분의 기능을 이용가능하지만 로그인 시 다양한 개인 맞춤형 서비스 제공이 가능합니다.', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAQ
VALUES (SQ_FAQ.nextval, '질문이 없으면 어떡하죠?', '저도 빈칸 채우기가 힘들어서 굳이 질문안하셔도 됩니다.', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


-- Todo:질문과 답변 테이블
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문', '해결', '홍길동', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문2', '해결2', '장길산', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문3', '해결3', '임꺽정', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문4', '해결4', '전우치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문5', '해결5', '마루치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문6', '해결6', '아라치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

-- Todo:질문 테이블 세분화
-- Todo:답변 테이블이랑 qno조인 예정
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문', '내용', '홍길동', 0,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문2', '내용2', '장길산',0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문3', '내용3', '임꺽정',0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문4', '내용4', '전우치',0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문5', '내용5', '마루치', 0,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문6', '내용6', '아라치',0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);

-- Todo:답변 테이블 세분화
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '1', '답변', '홍길동', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '2', '답변2', '장길산', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '3', '답변3', '임꺽정', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '4', '답변4', '전우치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '5', '답변5', '마루치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '6', '답변6', '아라치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);


-- Todo:공지사항 테이블
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '사이트 이용 규칙에 대해', '타인을 비방하는 게시글은 관리자를 통해 삭제될 수 있습니다.', '관리자', 0, 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '음식점 정보에 관해', '사실과 다른 내용이 기재될 경우 통보없이 삭제될 수 있습니다.', '관리자', 0, 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '회원정보 관리에 대해', '보안을 강화하여 회원정보 유출이 안되게 신경쓰고 있습니다.', '관리자', 0, 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '이용약관에 대해', '불만이 있는 부분이 있다면 관리자에게 문의해주세요.', '전우치',  0, 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '사이트 제작에 대해', '5명이서 협업해서 제작한 사이트로 Vue.js와 Springboot를 이용해서 작업했습니다.', '마루치',  0, 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '질문사항에 대해', '질문게시판을 이용해주세요.', '아라치',  0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL,
        NULL);

-- Todo:자유게시판 테이블
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '장동혁', '코로나 확진이 되었어요', '솔직히 걸릴 줄 몰랐는데 막상 걸리니까 힘들고 아프네요','','','','',0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
        NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '전성혜', '고양이가 너무 귀여워요', '제 고양이 봐주세요','','','','',0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '조성모', '팀프로젝트 하는데 조장이 탈주했어요', '갑자기 코로나 걸렸다고 사라졌어요 어떡하죠','','','','',0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
        NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '박선영', '겨울에 듣기 좋은 노래 추천해주세요', '추운날씨에 듣기 좋은 곡이 있을까요','','','','',0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL,
        NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '권태현', '이번 4090 그래픽카드 어떤가요', '가격이 너무 비싸서 고민되요','','','','',0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL,
        NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '강아름', '내일 소개팅 나가는데 옷좀 봐주세요', '추워서 롱패딩만 입고 나가기엔 썸남이 너무 잘생겼어요','','','','', 0,'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '고건민', '저 성인 ADHD인가요?', '한가지에 집중을 잘 못하겠는데 의심됩니다','','','','', 0,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL,
        NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '최은빈', '그렇게 됐습니다', '뒷 내용이 궁금하신분은 연락주세요','','','','',0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '이빛나', '시어머니가 너무 귀찮게 굴어요', '집에 저만 있는데도 계속 찾아와서 절 너무 당황스럽게 하네요','','','','',0, 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '남궁민', '자취하는데 필수템 있을까요?', '이번에 취직해서 처음 자취인데 필수템이라고 할만한게 있을까요','','','','', 0,'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '김시습', '이번에 책 한권 냈는데 한번 봐주세요', '제목을 금오신화라고 지었는데 요즘 사람들은 잘 안볼까요?','','','','',0, 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);

-- Todo:예약 테이블
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '장동혁', '3', '010-1234-5678', '1', '2', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '장동혁', '2', '010-1234-5678', '2', '2', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '장동혁', '4', '010-1234-5678', '3', '2', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '장동혁', '2', '010-1234-5678', '4', '2', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '장동혁', '2', '010-1234-5678', '5', '2', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '조성모', '3', '010-1234-5678', '6', '3', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '조성모', '2', '010-1234-5678', '7', '3', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '조성모', '4', '010-1234-5678', '8', '3', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '조성모', '2', '010-1234-5678', '9', '3', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '전성혜', '2', '010-1234-5678', '10', '4', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '전성혜', '3', '010-1234-5678', '11', '4', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '전성혜', '2', '010-1234-5678', '12', '4', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '전성혜', '4', '010-1234-5678', '13', '4', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '권태현', '2', '010-1234-5678', '14', '5', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '권태현', '2', '010-1234-5678', '15', '5', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '박선영', '3', '010-1234-5678', '16', '6', '2022-12-24', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);

-- Todo:음식점 테이블
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '해목', '4.5','해운대구','0507-1385-3730','일식', '식사', '리뷰1','https://mp-seoul-image-production-s3.mangoplate.com/1129699_1620482534399327.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',1111,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '합천국밥집', '4.6','남구','051-628-4898','한식', '식사', '리뷰2','https://mp-seoul-image-production-s3.mangoplate.com/25551/j7nkzmgyxpmqqa.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',2222,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '톤쇼우', '4.1','금정구','051-517-1727','중식', '데이트', '리뷰3','https://mp-seoul-image-production-s3.mangoplate.com/872186_1608730709406579.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',333,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '미청식당', '4.3','기장군','051-721-7050','한식', '모임', '리뷰4','https://mp-seoul-image-production-s3.mangoplate.com/1049578_1634728853479974.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',4444,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '백객도', '4.3','동래구','051-554-5873','중식', '모임', '리뷰5','https://mp-seoul-image-production-s3.mangoplate.com/1515134_1669012125992684.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',545,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '디젤앤카멜리아스', '4.3','부산진구','010-9179-6960','일식', '회식', '리뷰6','https://mp-seoul-image-production-s3.mangoplate.com/586167_1609749120642980.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',1324,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '옥천횟집', '4.4','영도구','051-403-7771','한식', '데이트', '리뷰7','https://mp-seoul-image-production-s3.mangoplate.com/693574_1667123439355703.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',123,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '다온나루', '3.4','강서구','051-832-1771','중식', '데이트', '리뷰8','https://mp-seoul-image-production-s3.mangoplate.com/393053/2032908_1653224070853_50338?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',342,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '금수복국', '4.4','해운대구','051-742-3600','양식', '식사', '리뷰9','https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/584169_1492330956578913.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',123,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '초원복국', '4.2','남구','051-628-3935','한식', '식사', '리뷰10','https://mp-seoul-image-production-s3.mangoplate.com/546909_1536072584565408.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',453,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '양자강', '3.8','금정구','051-583-1266','중식', '모임', '리뷰11','https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/9388_1480730005476394.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',234,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '일광대복집', '4.3','기장군','051-721-1561','한식', '회식', '리뷰12','https://mp-seoul-image-production-s3.mangoplate.com/147811_1633838192987199.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',2345,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '오노고로', '3.9','동래구','0507-1347-2015','중식', '데이트', '리뷰13','https://mp-seoul-image-production-s3.mangoplate.com/693546_1670850112205255.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',543,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '로바타아키', '4.2','부산진구','0507-1322-3415','양식', '모임', '리뷰14','https://mp-seoul-image-production-s3.mangoplate.com/1042441_1605430643484440.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',324,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '일구향만두', '4.0','영도구','051-418-7285','한식', '데이트', '리뷰15','https://mp-seoul-image-production-s3.mangoplate.com/348107/1466243_1670838071029_17000?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',543,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, '대저할매국수', '2.7','강서구','051-973-0837','한식', '회식', '리뷰16','https://mp-seoul-image-production-s3.mangoplate.com/16929/reviews/bc862256e507.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80',443,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);


-- Todo:리뷰 테이블
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '홍길동', '1', '내용', '4', '사진', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '장길산', '2', '내용2', '5', '사진2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '임꺽정', '3', '내용3', '3', '사진3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '전우치', '4', '내용4', '2', '사진4', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '마루치', '5', '내용5', '4', '사진5', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '아라치', '6', '내용6', '3', '사진6', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

-- Todo: 메뉴 테이블
-- Todo: 음식점 테이블이랑 조인 예정
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '특히츠마부시', '57000', '1', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '히츠마부시', '39000', '1', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '특카이센동', '50000', '1', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '카이센동', '36000', '1', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '생연어덮밥+네기도로', '22000', '1', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '따로국밥', '10000', '2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '내장따로국밥', '10000', '2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '수육백반', '11000', '2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '수육 (대)', '40000', '2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '순대 (대)', '30000', '2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '버크셔K로스카츠', '14500', '3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '히레카츠', '11500', '3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '로스카츠', '10500', '3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '간쥬쿠카츠', '10500', '3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '모듬카츠', '14500', '3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
-- 일단 여기까지 넣어봄
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴4', '가격4', '4', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴4', '가격4', '4', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴4', '가격4', '4', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴4', '가격4', '4', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴5', '가격5', '5', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴5', '가격5', '5', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴5', '가격5', '5', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴5', '가격5', '5', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴6', '가격6', '6', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴6', '가격6', '6', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴6', '가격6', '6', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴6', '가격6', '6', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴6', '가격6', '6', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴7', '가격7', '7', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴7', '가격7', '7', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴7', '가격7', '7', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴7', '가격7', '7', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴7', '가격7', '7', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴8', '가격8', '8', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴8', '가격8', '8', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴8', '가격8', '8', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴8', '가격8', '8', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴8', '가격8', '8', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴9', '가격9', '9', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴9', '가격9', '9', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴9', '가격9', '9', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴9', '가격9', '9', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴9', '가격9', '9', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴10', '가격10', '10', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴10', '가격10', '10', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴10', '가격10', '10', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴10', '가격10', '10', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴10', '가격10', '10', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴11', '가격11', '11', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴11', '가격11', '11', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴11', '가격11', '11', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴11', '가격11', '11', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴11', '가격11', '11', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴12', '가격12', '12', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴12', '가격12', '12', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴12', '가격12', '12', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴12', '가격12', '12', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴12', '가격12', '12', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴13', '가격13', '13', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴13', '가격13', '13', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴13', '가격13', '13', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴13', '가격13', '13', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴13', '가격13', '13', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴14', '가격14', '14', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴14', '가격14', '14', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴14', '가격14', '14', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴14', '가격14', '14', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴15', '가격15', '15', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴15', '가격15', '15', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴15', '가격15', '15', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴15', '가격15', '15', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴16', '가격16', '16', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴16', '가격16', '16', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴16', '가격16', '16', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴16', '가격16', '16', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴16', '가격16', '16', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);

-- Todo: 평점 테이블
-- Todo: 리뷰 테이블이랑 조인 예정
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '1', '1', '1', '1', '1', '1', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '2', '2', '2', '2', '2', '2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '3', '3', '3', '3', '3', '3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '4', '4', '4', '4', '4', '4', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '5', '5', '5', '5', '5', '5', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


-- Todo:푸드컬럼 테이블
INSERT INTO TB_COLUMN
VALUES (SQ_COLUMN.nextval, '연말연시 맛집 추천', '한 해의 마지막과 새해의 시작을 이곳에서','사진','장동혁', '2', 0,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_COLUMN
VALUES (SQ_COLUMN.nextval, '서면 맛집 Best5', '부산토박이가 알려주는 로컬맛집', '사진2', '전성혜', '4',0,'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_COLUMN
VALUES (SQ_COLUMN.nextval, '여기가 바로 가성비 맛집', '서비스는 필요없다. 오로지 가성비로만 승부', '사진3', '조성모', '3',0, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);


-- Todo:찜한 음식점 테이블
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 1, 4, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 1, 3, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 1, 2, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 1, 8, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 2, 8, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 2, 1, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 2, 5, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 2, 3, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 3, 10, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 3, 1, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 3, 9, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FAVORITE
VALUES (SQ_FAVORITE.nextval, 3, 4, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


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
VALUES (SQ_USER.NEXTVAL, 'forbob', 'forbob@naver.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6',
        '강태경', '1991.01.01', 'male', '010-2020-0202', '부산시 영도구 남항동 123가', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_USER
VALUES(SQ_USER.NEXTVAL, 'JANGDH', 'JANG@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6','장동혁', '1992.02.02', 'male', '010-2020-0202', '부산시 영도구 남항동 123가', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_USER
VALUES (SQ_USER.NEXTVAL, 'JOSM', 'JO@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6', '조성모',
        '1993.03.03', 'male', '010-2020-0202', '부산시 영도구 남항동 123가', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL,
        NULL);
INSERT INTO TB_USER
VALUES(SQ_USER.NEXTVAL, 'JUNSH', 'JUN@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6','전성혜', '1993.03.03', 'female', '010-2020-0202', '서울특별시 종로구 팔판길 1-6', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_USER
VALUES (SQ_USER.NEXTVAL, 'KWONTH', 'KWON@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6',
        '권태현', '1993.03.03', 'male', '010-2020-0202', '서울특별시 종로구 팔판길 1-6', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_USER
VALUES(SQ_USER.NEXTVAL, 'PARKSY', 'PARK@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6','박선영', '1993.03.03', 'female', '010-2020-0202', '서울특별시 종로구 팔판길 1-6', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);


-- TODO: (첫번째 : 유저id(시퀀스), 두번째 : 1(일반유저) 2(관리자) )
INSERT INTO TB_USER_ROLE
VALUES (1, 2);
INSERT INTO TB_USER_ROLE
VALUES (2, 1);
INSERT INTO TB_USER_ROLE
VALUES (3, 1);
INSERT INTO TB_USER_ROLE
VALUES (4, 1);
INSERT INTO TB_USER_ROLE
VALUES (5, 1);
INSERT INTO TB_USER_ROLE
VALUES (6, 1);

COMMIT;