-- Todo:자주묻는질문 테이블

INSERT INTO TB_FAQ
VALUES (SQ_FAQ.nextval, '제목', '해결방법', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_FAQ
VALUES (SQ_FAQ.nextval, '제목2', '해결방법2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_FAQ
VALUES (SQ_FAQ.nextval, '제목3', '해결방법3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_FAQ
VALUES (SQ_FAQ.nextval, '제목4', '해결방법4', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);


-- Todo:질문과 답변 테이블
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문', '해결','홍길동', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문2', '해결2','장길산', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문3', '해결3','임꺽정','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문4', '해결4','전우치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문5', '','마루치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_QNA
VALUES (SQ_QNA.nextval, '질문6', '','아라치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);

-- Todo:질문 테이블 세분화
-- Todo:답변 테이블이랑 qno조인 예정
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문', '내용','홍길동', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문2', '내용2','장길산', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문3', '내용3','임꺽정','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문4', '내용4','전우치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문5', '내용5','마루치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_QUESTION
VALUES (SQ_QUESTION.nextval, '질문6', '내용6','아라치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);

-- Todo:답변 테이블 세분화
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '1', '답변', '홍길동', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '2', '답변2', '장길산', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '3', '답변3', '임꺽정','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '4', '답변4', '전우치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '5', '답변5', '마루치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_ANSWER
VALUES (SQ_ANSWER.nextval, '6', '답변6', '아라치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);


-- Todo:공지사항 테이블
INSERT INTO TB_ANNOUNCE
VALUES (SQ_QNA.nextval, '공지', '내용','홍길동', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_QNA.nextval, '공지2', '내용2','장길산', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_QNA.nextval, '공지3', '내용3','임꺽정','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_QNA.nextval, '공지4', '내용4','전우치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_QNA.nextval, '공지5', '내용5','마루치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_ANNOUNCE
VALUES (SQ_QNA.nextval, '공지6', '내용6','아라치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);

-- Todo:자유게시판 테이블
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '작성자1', '제목1', '내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1내용1', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '작성자2', '제목2', '내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2내용2','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '작성자3', '제목3', '내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3내용3','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '작성자4', '제목4', '내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4내용4','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '작성자5', '제목5', '내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5내용5','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '작성자6', '제목6', '내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6내용6','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '작성자7', '제목7', '내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7내용7','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '작성자8', '제목8', '내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8내용8','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '작성자9', '제목9', '내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9내용9','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '작성자10', '제목10', '내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10내용10','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);
INSERT INTO TB_FREE
VALUES (SQ_FREE.nextval, '작성자11', '제목11', '내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11내용11','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD') ,NULL, NULL);

-- Todo:예약 테이블
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당1', '홍길동', '3', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당2', '장길산', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당3', '임꺽정', '4', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당4', '전우치', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당5', '아라치', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당6', '홍길동', '3', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당7', '장길산', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당8', '임꺽정', '4', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당9', '전우치', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당10', '아라치', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당11', '홍길동', '3', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당12', '장길산', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당13', '임꺽정', '4', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당14', '전우치', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당15', '아라치', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당16', '홍길동', '3', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당17', '장길산', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당18', '임꺽정', '4', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당19', '전우치', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당20', '아라치', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당21', '홍길동', '3', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당22', '장길산', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당23', '임꺽정', '4', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당24', '전우치', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_RESERVATION
VALUES (SQ_RESERVATION.nextval, '식당25', '아라치', '2', '010', '1234', '5678', '12/24/2022', '18:30', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);

-- Todo:음식점 테이블
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER1', '4.5','서울','010-0000-0000','일식', '데이트', '리뷰1',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER2', '4.6','부산','010-0000-0000','한식', '모임', '리뷰2',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER3', '2.6','부산','010-0000-0000','중식', '회식', '리뷰3',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER4', '2.5','부산','010-0000-0000','양식', '데이트', '리뷰4',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER5', '4.9','부산','010-0000-0000','한식', '모임', '리뷰5',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER6', '3.5','부산','010-0000-0000','일식', '회식', '리뷰6',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER7', '5.0','부산','010-0000-0000','한식', '데이트', '리뷰7',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER8', '3.4','부산','010-0000-0000','중식', '모임', '리뷰8',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER9', '3.5','부산','010-0000-0000','양식', '회식', '리뷰9',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER10', '3.0','부산','010-0000-0000','한식', '데이트', '리뷰10',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER11', '4.2','부산','010-0000-0000','일식', '모임', '리뷰11',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER12', '4.6','부산','010-0000-0000','한식', '회식', '리뷰12',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER13', '1.5','부산','010-0000-0000','중식', '데이트', '리뷰13',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER14', '3.6','부산','010-0000-0000','양식', '모임', '리뷰14',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);
INSERT INTO TB_DINER
VALUES (SQ_DINER.nextval, 'DINER15', '1.9','부산','010-0000-0000','한식', '회식', '리뷰15',' ','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),NULL, NULL);

-- Todo:리뷰 테이블
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '리뷰', '내용','사진','홍길동', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '리뷰2', '내용2', '사진2', '장길산', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '리뷰3', '내용3', '사진3', '임꺽정','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '리뷰4', '내용4', '사진4', '전우치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '리뷰5', '내용5', '사진5', '마루치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_REVIEW
VALUES (SQ_REVIEW.nextval, '리뷰6', '내용6', '사진6','아라치','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);

-- Todo: 메뉴 테이블
-- Todo: 음식점 테이블이랑 조인 예정
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴1', '가격1', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴2', '가격2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴3', '가격3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴4', '가격4', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_MENU
VALUES (SQ_MENU.nextval, '메뉴5', '가격5', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);

-- Todo: 평점 테이블
-- Todo: 리뷰 테이블이랑 조인 예정
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '1', '1', '1', '1', '1', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '2', '2', '2', '2', '2', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '3', '3', '3', '3', '3', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '4', '4', '4', '4', '4', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_SCORE
VALUES (SQ_SCORE.nextval, '5', '5', '5', '5', '5', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);


-- Todo:푸드컬럼 테이블
INSERT INTO TB_COLUMN
VALUES (SQ_COLUMN.nextval, '연말연시 맛집 추천', '한 해의 마지막과 새해의 시작을 이곳에서','사진','장동혁', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_COLUMN
VALUES (SQ_COLUMN.nextval, '서면 맛집 Best5', '부산토박이가 알려주는 로컬맛집', '사진2', '전성혜', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_COLUMN
VALUES (SQ_COLUMN.nextval, '여기가 바로 가성비 맛집', '서비스는 필요없다. 오로지 가성비로만 승부', '사진3', '조성모','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);



-- TODO: login 샘플 데이터
INSERT INTO TB_ROLE VALUES(SQ_ROLE.NEXTVAL, 'ROLE_USER','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
-- INSERT INTO TB_ROLE(id, name) VALUES(SQ_ROLE.NEXTVAL, 'ROLE_MODERATOR');
INSERT INTO TB_ROLE VALUES(SQ_ROLE.NEXTVAL, 'ROLE_ADMIN','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);

-- admin user 1명 최초 생성
-- id : forbob
-- password : 123456
-- email : forbob@naver.com
-- roles : ROLE_ADMIN

INSERT INTO TB_USER
VALUES(SQ_USER.NEXTVAL, 'forbob', 'forbob@naver.com', '$2a$10$TG1a5ywSrGNgf7/fFH.m0.EdTzHax8AGYNeAr8aIseF3DKyO0lDti','강태경', '1991.01.01', 'male', '010-2020-0202', '부산시 영도구 남항동 123가', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_USER
VALUES(SQ_USER.NEXTVAL, 'for', 'forbob@naver.com', '$2a$10$TG1a5ywSrGNgf7/fFH.m0.EdTzHax8AGYNeAr8aIseF3DKyO0lDti','장길산', '1992.02.02', 'female', '010-2020-0202', '부산시 영도구 남항동 123가', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_USER
VALUES(SQ_USER.NEXTVAL, 'asdf', 'asdf@gmail.com', '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6','홍길동', '1993.03.03', 'male', '010-2020-0202', '부산시 영도구 남항동 123가', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);
INSERT INTO TB_USER
VALUES(SQ_USER.NEXTVAL, 'asdfasdf', 'asdfasdf@gmail.com', '$2a$10$eiNbF9k9tAjrSUEp9i2LG.CxJ1B/EBjqkqoHgAVb2X03O50PPrTGq','asdf', '1993.03.03', 'male', '010-2020-0202', '서울특별시 종로구 팔판길 1-6', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') ,NULL, NULL);


-- TODO: (첫번째 : 유저id(시퀀스), 두번째 : 1(일반유저) 2(관리자) )
INSERT INTO TB_USER_ROLE
VALUES(1, 2);
INSERT INTO TB_USER_ROLE
VALUES(2, 1);
INSERT INTO TB_USER_ROLE
VALUES(3, 1);
INSERT INTO TB_USER_ROLE
VALUES(4, 1);

COMMIT;