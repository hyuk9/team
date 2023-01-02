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
VALUES (SQ_QUESTION.nextval, '질문', '내용', '홍길동', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문2', '내용2', '장길산', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문3', '내용3', '임꺽정', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문4', '내용4', '전우치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문5', '내용5', '마루치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문6', '내용6', '아라치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

-- Todo:답변 테이블 세분화
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '1', '답변', '홍길동', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '2', '답변2', '장길산', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '3', '답변3', '임꺽정', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '4', '답변4', '전우치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '5', '답변5', '마루치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '6', '답변6', '아라치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


-- Todo:공지사항 테이블
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '사이트 이용 규칙에 대해', '타인을 비방하는 게시글은 관리자를 통해 삭제될 수 있습니다.', '관리자', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '음식점 정보에 관해', '사실과 다른 내용이 기재될 경우 통보없이 삭제될 수 있습니다.', '관리자', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '회원정보 관리에 대해', '보안을 강화하여 회원정보 유출이 안되게 신경쓰고 있습니다.', '관리자', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '이용약관에 대해', '불만이 있는 부분이 있다면 관리자에게 문의해주세요.', '전우치', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '사이트 제작에 대해', '5명이서 협업해서 제작한 사이트로 Vue.js와 Springboot를 이용해서 작업했습니다.', '마루치', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_ANNOUNCE.nextval, '질문사항에 대해', '질문게시판을 이용해주세요.', '아라치', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL,
        NULL);

-- Todo:자유게시판 테이블
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '장동혁', '코로나 확진이 되었어요', '솔직히 걸릴 줄 몰랐는데 막상 걸리니까 힘들고 아프네요', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
        NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '전성혜', '고양이가 너무 귀여워요', '제 고양이 봐주세요', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '조성모', '팀프로젝트 하는데 조장이 탈주했어요', '갑자기 코로나 걸렸다고 사라졌어요 어떡하죠', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
        NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '박선영', '겨울에 듣기 좋은 노래 추천해주세요', '추운날씨에 듣기 좋은 곡이 있을까요', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL,
        NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '권태현', '이번 4090 그래픽카드 어떤가요', '가격이 너무 비싸서 고민되요', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL,
        NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '강아름', '내일 소개팅 나가는데 옷좀 봐주세요', '추워서 롱패딩만 입고 나가기엔 썸남이 너무 잘생겼어요', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '고건민', '저 성인 ADHD인가요?', '한가지에 집중을 잘 못하겠는데 의심됩니다', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL,
        NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '최은빈', '그렇게 됐습니다', '뒷 내용이 궁금하신분은 연락주세요', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '이빛나', '시어머니가 너무 귀찮게 굴어요', '집에 저만 있는데도 계속 찾아와서 절 너무 당황스럽게 하네요', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '남궁민', '자취하는데 필수템 있을까요?', '이번에 취직해서 처음 자취인데 필수템이라고 할만한게 있을까요', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '김시습', '이번에 책 한권 냈는데 한번 봐주세요', '제목을 금오신화라고 지었는데 요즘 사람들은 잘 안볼까요?', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'), NULL, NULL);

-- Todo:예약 테이블
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당1', '홍길동', '3', '010-1234-5678', '1', '12/24/2022', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당2', '장길산', '2', '010-1234-5678', '2', '12/24/2022', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당3', '임꺽정', '4', '010-1234-5678', '3', '12/24/2022', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당4', '전우치', '2', '010-1234-5678', '4', '12/24/2022', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당5', '아라치', '2', '010-1234-5678', '5', '12/24/2022', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION

VALUES (SQ_RESERVATION.nextval, '식당6', '홍길동', '3', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당7', '장길산', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당8', '임꺽정', '4', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당9', '전우치', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당10', '아라치', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당11', '홍길동', '3', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당12', '장길산', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당13', '임꺽정', '4', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당14', '전우치', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당15', '아라치', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당16', '홍길동', '3', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당17', '장길산', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당18', '임꺽정', '4', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당19', '전우치', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당20', '아라치', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당21', '홍길동', '3', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당22', '장길산', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당23', '임꺽정', '4', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당24', '전우치', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당25', '아라치', '2', '010', '1234', '5678', '2023-01-14', '18:30', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

-- Todo:음식점 테이블
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER1', '4.5', '서울', '010-0000-0000', '일식', '데이트', '리뷰1', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER2', '4.6', '부산', '010-0000-0000', '한식', '모임', '리뷰2', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER3', '2.6', '부산', '010-0000-0000', '중식', '회식', '리뷰3', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER4', '2.5', '부산', '010-0000-0000', '양식', '데이트', '리뷰4', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER5', '4.9', '부산', '010-0000-0000', '한식', '모임', '리뷰5', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER6', '3.5', '부산', '010-0000-0000', '일식', '회식', '리뷰6', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER7', '5.0', '부산', '010-0000-0000', '한식', '데이트', '리뷰7', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER8', '3.4', '부산', '010-0000-0000', '중식', '모임', '리뷰8', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER9', '3.5', '부산', '010-0000-0000', '양식', '회식', '리뷰9', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER10', '3.0', '부산', '010-0000-0000', '한식', '데이트', '리뷰10', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER11', '4.2', '부산', '010-0000-0000', '일식', '모임', '리뷰11', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER12', '4.6', '부산', '010-0000-0000', '한식', '회식', '리뷰12', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER13', '1.5', '부산', '010-0000-0000', '중식', '데이트', '리뷰13', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER14', '3.6', '부산', '010-0000-0000', '양식', '모임', '리뷰14', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER15', '1.9', '부산', '010-0000-0000', '한식', '회식', '리뷰15', ' ', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

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
VALUES (SQ_MENU.nextval, '메뉴1', '가격1', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴2', '가격2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴3', '가격3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴4', '가격4', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴5', '가격5', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

-- Todo: 평점 테이블
-- Todo: 리뷰 테이블이랑 조인 예정
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '1', '1', '1', '1', '1', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '2', '2', '2', '2', '2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '3', '3', '3', '3', '3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '4', '4', '4', '4', '4', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '5', '5', '5', '5', '5', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


-- Todo:푸드컬럼 테이블
INSERT INTO TB_COLUMN
VALUES (SQ_COLUMN.nextval, '연말연시 맛집 추천', '한 해의 마지막과 새해의 시작을 이곳에서', '사진', '장동혁', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_COLUMN
VALUES (SQ_COLUMN.nextval, '서면 맛집 Best5', '부산토박이가 알려주는 로컬맛집', '사진2', '전성혜', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_COLUMN
VALUES (SQ_COLUMN.nextval, '여기가 바로 가성비 맛집', '서비스는 필요없다. 오로지 가성비로만 승부', '사진3', '조성모', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


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
VALUES (SQ_USER.NEXTVAL, 'forbob', 'forbob@naver.com', '$2a$10$TG1a5ywSrGNgf7/fFH.m0.EdTzHax8AGYNeAr8aIseF3DKyO0lDti',
        '강태경', '1991.01.01', 'male', '010-2020-0202', '부산시 영도구 남항동 123가', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_USER
VALUES (SQ_USER.NEXTVAL, 'JANGDH', 'JANG@gmail.com', '$2a$10$TG1a5ywSrGNgf7/fFH.m0.EdTzHax8AGYNeAr8aIseF3DKyO0lDti',
        '장동혁', '1992.02.02', 'female', '010-2020-0202', '부산시 영도구 남항동 123가', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_USER
VALUES (SQ_USER.NEXTVAL, 'JOSM', 'JO@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6', '조성모',
        '1993.03.03', 'male', '010-2020-0202', '부산시 영도구 남항동 123가', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL,
        NULL);
INSERT INTO TB_USER
VALUES (SQ_USER.NEXTVAL, 'JUNSH', 'JUN@gmail.com', '$2a$10$eiNbF9k9tAjrSUEp9i2LG.CxJ1B/EBjqkqoHgAVb2X03O50PPrTGq',
        '전성혜', '1993.03.03', 'male', '010-2020-0202', '서울특별시 종로구 팔판길 1-6', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_USER
VALUES (SQ_USER.NEXTVAL, 'KWONTH', 'KWON@gmail.com', '$2a$10$eiNbF9k9tAjrSUEp9i2LG.CxJ1B/EBjqkqoHgAVb2X03O50PPrTGq',
        '권태현', '1993.03.03', 'male', '010-2020-0202', '서울특별시 종로구 팔판길 1-6', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_USER
VALUES (SQ_USER.NEXTVAL, 'PARKSY', 'PARK@gmail.com', '$2a$10$eiNbF9k9tAjrSUEp9i2LG.CxJ1B/EBjqkqoHgAVb2X03O50PPrTGq',
        '박선영', '1993.03.03', 'male', '010-2020-0202', '서울특별시 종로구 팔판길 1-6', 'N',
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);


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