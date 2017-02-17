-- --------------------------------------------------------
-- 호스트:                          better4307.cafe24.com
-- 서버 버전:                        5.5.17-log - MySQL Community Server (GPL)
-- 서버 OS:                        Linux
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- better4307 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS `better4307`;
CREATE DATABASE IF NOT EXISTS `better4307` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `better4307`;

-- 테이블 better4307.ADMIN 구조 내보내기
DROP TABLE IF EXISTS `ADMIN`;
CREATE TABLE IF NOT EXISTS `ADMIN` (
  `adm_id` varchar(20) NOT NULL COMMENT '아이디',
  `brc_code` int(11) DEFAULT NULL COMMENT '지점코드',
  `adm_pw` varchar(20) NOT NULL COMMENT '비밀번호',
  `adm_auth` varchar(20) NOT NULL COMMENT '권한',
  `adm_date` datetime DEFAULT NULL COMMENT '승인일자',
  PRIMARY KEY (`adm_id`),
  KEY `FK_BRANCH_TO_ADMIN` (`brc_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='관리자';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.ANALYSIS 구조 내보내기
DROP TABLE IF EXISTS `ANALYSIS`;
CREATE TABLE IF NOT EXISTS `ANALYSIS` (
  `mov_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '영화코드',
  `anl_totalTicketCount` int(11) NOT NULL COMMENT '전체예매인원수',
  `anl_10sTicketCount` int(11) NOT NULL COMMENT '10대예매인원수',
  `anl_20sTicketCount` int(11) NOT NULL COMMENT '20대예매인원수',
  `anl_30sTicketCount` int(11) NOT NULL COMMENT '30대예매인원수',
  `anl_40sTicketCount` int(11) NOT NULL COMMENT '40대예매인원수',
  `anl_50sTicketCount` int(11) NOT NULL COMMENT '50대예매인원수',
  `anl_over50sTicketCount` int(11) NOT NULL COMMENT '50대이상',
  `anl_manTicketCount` int(11) NOT NULL COMMENT '남성예매인원수',
  `anl_womanTicketCount` int(11) NOT NULL COMMENT '여성예매인원수',
  `anl_acSales` int(11) NOT NULL COMMENT '누적매출액',
  `anl_finalModifyDate` datetime NOT NULL COMMENT '최종수정일자',
  PRIMARY KEY (`mov_code`)
) ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='영화 분석/통계';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.BRANCH 구조 내보내기
DROP TABLE IF EXISTS `BRANCH`;
CREATE TABLE IF NOT EXISTS `BRANCH` (
  `brc_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '지점코드',
  `brc_name` varchar(20) NOT NULL COMMENT '지점명',
  `brc_local` varchar(20) NOT NULL COMMENT '지역',
  `brc_addr` varchar(50) NOT NULL COMMENT '주소',
  `brc_infoDetail` varchar(100) NOT NULL COMMENT '소개',
  `brc_imgPath` varchar(100) NOT NULL COMMENT '이미지 경로',
  PRIMARY KEY (`brc_code`)
) ENGINE=MyISAM AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='지점';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.BRANCH_DAY_COUNT 구조 내보내기
DROP TABLE IF EXISTS `BRANCH_DAY_COUNT`;
CREATE TABLE IF NOT EXISTS `BRANCH_DAY_COUNT` (
  `brcCnt_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '지점별 예매/매출코드',
  `brc_code` int(11) NOT NULL COMMENT '지점코드',
  `mov_code` int(11) NOT NULL COMMENT '영화코드',
  `brcCnt_clientCount` int(11) NOT NULL COMMENT '일일 관객수',
  `brcCnt_saleTotal` int(11) NOT NULL COMMENT '매출액',
  `brcCnt_date` date NOT NULL COMMENT '날짜',
  PRIMARY KEY (`brcCnt_code`),
  KEY `FK_BRANCH_TO_BRANCH_DAY_COUNT` (`brc_code`),
  KEY `FK_MOVIE_TO_BRANCH_DAY_COUNT` (`mov_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='지점별 일일예매/매출';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.CHARACTER 구조 내보내기
DROP TABLE IF EXISTS `CHARACTER`;
CREATE TABLE IF NOT EXISTS `CHARACTER` (
  `char_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '인물코드',
  `char_korName` varchar(30) NOT NULL COMMENT '이름',
  `char_engName` varchar(30) NOT NULL COMMENT '영문이름',
  `char_birth` date NOT NULL COMMENT '생년월일',
  `char_gender` varchar(2) NOT NULL COMMENT '성별',
  `char_profileImgPath` varchar(100) NOT NULL COMMENT '프로필사진경로',
  `char_nation` varchar(20) NOT NULL COMMENT '국적',
  `char_bioGraphy` varchar(200) NOT NULL COMMENT '바이오그래피',
  `char_finalModifyDate` datetime NOT NULL COMMENT '최종수정일자',
  PRIMARY KEY (`char_code`)
) ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='인물';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.CHARACTERS 구조 내보내기
DROP TABLE IF EXISTS `CHARACTERS`;
CREATE TABLE IF NOT EXISTS `CHARACTERS` (
  `chars_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '인물(다)코드',
  `mov_code` int(11) NOT NULL COMMENT '영화코드',
  `char_code` int(11) NOT NULL COMMENT '인물코드',
  PRIMARY KEY (`chars_code`),
  KEY `FK_CHARACTER_TO_CHARACTERS` (`char_code`),
  KEY `FK_MOVIE_TO_CHARACTERS` (`mov_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='인물(다:다)';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.DISCOUNT_INFO 구조 내보내기
DROP TABLE IF EXISTS `DISCOUNT_INFO`;
CREATE TABLE IF NOT EXISTS `DISCOUNT_INFO` (
  `dcinf_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '할인코드',
  `dcinf_info` varchar(10) NOT NULL COMMENT '할인정보',
  `dcinf_price` int(11) NOT NULL COMMENT '할인가',
  `dcinf_applyYear` int(11) NOT NULL COMMENT '적용년',
  `dcinf_status` varchar(10) NOT NULL COMMENT '현재적용유무',
  `dcinf_date` datetime NOT NULL COMMENT '시스템등록일자',
  PRIMARY KEY (`dcinf_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='할인정보 (조조/심야/청소년)';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.GRADE 구조 내보내기
DROP TABLE IF EXISTS `GRADE`;
CREATE TABLE IF NOT EXISTS `GRADE` (
  `mov_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '영화코드',
  `gra_acGrade` int(11) NOT NULL COMMENT '총누적평점',
  `gra_totalNum` int(11) NOT NULL COMMENT '총평가인원수',
  `gra_beforeOpenGrade` int(11) NOT NULL COMMENT '개봉전 누적 평점',
  `gra_beforeOpenNum` int(11) NOT NULL COMMENT '개봉전 평가인원',
  `gra_vistorGrade` int(11) NOT NULL COMMENT '관람객 누적 평점',
  `gra_vistorGradeNum` int(11) NOT NULL COMMENT '관람객 평가인원',
  PRIMARY KEY (`mov_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='평점분석';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.MEMBER 구조 내보내기
DROP TABLE IF EXISTS `MEMBER`;
CREATE TABLE IF NOT EXISTS `MEMBER` (
  `mem_id` varchar(20) NOT NULL COMMENT '아이디',
  `mem_pw` varchar(20) NOT NULL COMMENT '비밀번호',
  `mem_phone` varchar(20) NOT NULL COMMENT '휴대폰번호',
  `mem_name` varchar(20) NOT NULL COMMENT '이름',
  `mem_gender` varchar(2) NOT NULL COMMENT '성별',
  `mem_birth` date NOT NULL COMMENT '생년월일',
  `mem_postNo` int(11) NOT NULL COMMENT '우편번호',
  `mem_addr` varchar(50) NOT NULL COMMENT '주소',
  `mem_mail` varchar(50) NOT NULL COMMENT '이메일',
  `mem_mileage` int(11) NOT NULL COMMENT '마일리지',
  `mem_joinDay` datetime NOT NULL COMMENT '가입일',
  `mem_status` varchar(20) DEFAULT NULL COMMENT '회원상태(일반,탈퇴)',
  `mem_leaveDay` datetime DEFAULT NULL COMMENT '탈퇴일',
  PRIMARY KEY (`mem_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='회원';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.MILEAGE 구조 내보내기
DROP TABLE IF EXISTS `MILEAGE`;
CREATE TABLE IF NOT EXISTS `MILEAGE` (
  `mil_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '마일리지로그코드',
  `pmt_code` int(11) NOT NULL COMMENT '결제코드',
  `mem_id` varchar(20) NOT NULL COMMENT '아이디',
  `mil_use` int(11) NOT NULL COMMENT '사용마일리지',
  `mil_save` int(11) NOT NULL COMMENT '적립마일리지',
  `mil_date` datetime NOT NULL COMMENT '날짜',
  PRIMARY KEY (`mil_code`),
  KEY `FK_MEMBER_TO_MILEAGE` (`mem_id`),
  KEY `FK_PAYMENT_TO_MILEAGE` (`pmt_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='마일리지적립/사용기록';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.MOVIE 구조 내보내기
DROP TABLE IF EXISTS `MOVIE`;
CREATE TABLE IF NOT EXISTS `MOVIE` (
  `mov_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '영화코드',
  `mov_korName` varchar(30) NOT NULL COMMENT '영화한글제목',
  `mov_engName` varchar(30) NOT NULL COMMENT '영화영문제목',
  `mov_nation` varchar(20) NOT NULL COMMENT '국가',
  `mov_grade` varchar(20) NOT NULL COMMENT '등급',
  `mov_genre` varchar(20) NOT NULL COMMENT '장르',
  `mov_maker` varchar(50) NOT NULL COMMENT '제작사',
  `mov_runningTime` time NOT NULL COMMENT '러닝타임',
  `mov_openDate` date NOT NULL COMMENT '개봉일',
  `mov_infoDetail` varchar(200) NOT NULL COMMENT '상세설명',
  `mov_imgPath` varchar(100) NOT NULL COMMENT '썸네일이미지경로',
  `mov_videoPath` varchar(100) NOT NULL COMMENT '영상경로',
  `mov_status` varchar(20) NOT NULL COMMENT '현재상영여부',
  `mov_finalModifyDate` datetime NOT NULL COMMENT '최종수정일자',
  PRIMARY KEY (`mov_code`)
) ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='영화';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.NON_MEMBER 구조 내보내기
DROP TABLE IF EXISTS `NON_MEMBER`;
CREATE TABLE IF NOT EXISTS `NON_MEMBER` (
  `nmem_code` int(11) NOT NULL COMMENT '비회원코드',
  `nmem_phone` int(11) NOT NULL COMMENT '휴대폰번호',
  `nmem_name` varchar(20) NOT NULL COMMENT '이름',
  `nmem_birth` date NOT NULL COMMENT '생년월일',
  `nmem_pw` varchar(20) NOT NULL COMMENT '비밀번호',
  PRIMARY KEY (`nmem_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='비회원';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.PAYMENT 구조 내보내기
DROP TABLE IF EXISTS `PAYMENT`;
CREATE TABLE IF NOT EXISTS `PAYMENT` (
  `pmt_code` int(11) NOT NULL COMMENT '결제코드',
  `scs_code` int(11) NOT NULL COMMENT '상영코드',
  `mem_id` varchar(20) DEFAULT NULL COMMENT '아이디',
  `nmem_code` int(11) DEFAULT NULL COMMENT '비회원코드',
  `scco_code` int(11) NOT NULL COMMENT '상영단가코드',
  `dcinf_code` int(11) NOT NULL COMMENT '할인코드',
  `pmt_ticketNum` int(11) NOT NULL COMMENT '인원',
  `pmt_price` int(11) NOT NULL COMMENT '결제금액',
  `pmt_date` datetime NOT NULL COMMENT '결제날짜',
  PRIMARY KEY (`pmt_code`),
  KEY `FK_SCREEN_COST_TO_PAYMENT` (`scco_code`),
  KEY `FK_DISCOUNT_INFO_TO_PAYMENT` (`dcinf_code`),
  KEY `FK_MEMBER_TO_PAYMENT` (`mem_id`),
  KEY `FK_SCREEN_SCHEDULE_TO_PAYMENT` (`scs_code`),
  KEY `FK_NON_MEMBER_TO_PAYMENT` (`nmem_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='결제';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.REPLY 구조 내보내기
DROP TABLE IF EXISTS `REPLY`;
CREATE TABLE IF NOT EXISTS `REPLY` (
  `rp_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '한줄평코드',
  `mem_id` varchar(20) NOT NULL COMMENT '아이디',
  `mov_code` int(11) NOT NULL COMMENT '영화코드',
  `rp_title` varchar(20) NOT NULL COMMENT '제목',
  `rp_detail` varchar(50) NOT NULL COMMENT '내용',
  `rp_recomend` int(11) NOT NULL COMMENT '추천수',
  `rp_grade` int(11) NOT NULL COMMENT '평점',
  `rp_insertDate` datetime NOT NULL COMMENT '등록일자',
  PRIMARY KEY (`rp_code`),
  KEY `FK_MOVIE_TO_REPLY` (`mov_code`),
  KEY `FK_MEMBER_TO_REPLY` (`mem_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='한줄평/평점';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.REPLY_RECOMMEND 구조 내보내기
DROP TABLE IF EXISTS `REPLY_RECOMMEND`;
CREATE TABLE IF NOT EXISTS `REPLY_RECOMMEND` (
  `reco_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '한줄평추천코드',
  `rp_code` int(11) NOT NULL COMMENT '한줄평코드',
  `mem_id` varchar(20) NOT NULL COMMENT '한줄평 추천 아이디',
  `reco_date` datetime NOT NULL COMMENT '추천일자',
  PRIMARY KEY (`reco_code`),
  KEY `FK_REPLY_TO_REPLY_RECOMMEND` (`rp_code`),
  KEY `FK_MEMBER_TO_REPLY_RECOMMEND` (`mem_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='한줄평추천수';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.SCREEN 구조 내보내기
DROP TABLE IF EXISTS `SCREEN`;
CREATE TABLE IF NOT EXISTS `SCREEN` (
  `scr_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '상영관코드',
  `brc_code` int(11) NOT NULL COMMENT '지점코드',
  `scr_name` varchar(20) NOT NULL COMMENT '상영관명',
  `scr_rowSize` int(11) NOT NULL COMMENT '상영관행크기',
  `scr_colSize` int(11) NOT NULL COMMENT '상영관열크기',
  PRIMARY KEY (`scr_code`),
  KEY `FK_BRANCH_TO_SCREEN` (`brc_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='상영관';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.SCREEN_COST 구조 내보내기
DROP TABLE IF EXISTS `SCREEN_COST`;
CREATE TABLE IF NOT EXISTS `SCREEN_COST` (
  `scco_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '상영단가코드',
  `scco_screen` varchar(10) NOT NULL COMMENT '스크린',
  `scco_price` int(11) NOT NULL COMMENT '단가',
  `scco_applyYear` int(11) NOT NULL COMMENT '적용년',
  `scco_status` varchar(10) NOT NULL COMMENT '현재적용유무',
  `scco_date` datetime NOT NULL COMMENT '시스템등록일자',
  PRIMARY KEY (`scco_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='상영 단가 (2D,3D,IMAX)';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.SCREEN_SCHEDULE 구조 내보내기
DROP TABLE IF EXISTS `SCREEN_SCHEDULE`;
CREATE TABLE IF NOT EXISTS `SCREEN_SCHEDULE` (
  `scs_code` int(11) NOT NULL COMMENT '상영코드',
  `mov_code` int(11) NOT NULL COMMENT '영화코드',
  `brc_code` int(11) NOT NULL COMMENT '지점코드',
  `scr_code` int(11) NOT NULL COMMENT '상영관코드',
  `scs_date` date NOT NULL COMMENT '상영날짜',
  `scs_startTime` time NOT NULL COMMENT '상영시작시간',
  `scs_finishTime` time NOT NULL COMMENT '상영종료시간',
  `scs_screen` varchar(20) NOT NULL COMMENT '2d/3d/imax',
  `scs_timeDiscount` varchar(20) NOT NULL COMMENT '조조/일반/심야',
  `scs_insertDate` datetime NOT NULL COMMENT '등록일',
  PRIMARY KEY (`scs_code`),
  KEY `FK_SCREEN_TO_SCREEN_SCHEDULE` (`scr_code`),
  KEY `FK_BRANCH_TO_SCREEN_SCHEDULE` (`brc_code`),
  KEY `FK_MOVIE_TO_SCREEN_SCHEDULE` (`mov_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='상영일정';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.SEAT 구조 내보내기
DROP TABLE IF EXISTS `SEAT`;
CREATE TABLE IF NOT EXISTS `SEAT` (
  `seat_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '좌석코드',
  `scs_code` int(11) NOT NULL COMMENT '상영코드',
  `scr_code` int(11) NOT NULL COMMENT '상영관코드',
  `seta_row` char(1) NOT NULL COMMENT '행',
  `seat_col` int(11) NOT NULL COMMENT '열',
  `seat_useStatus` varchar(20) NOT NULL COMMENT '사용여부',
  PRIMARY KEY (`seat_code`),
  KEY `FK_SCREEN_SCHEDULE_TO_SEAT` (`scs_code`),
  KEY `FK_SCREEN_TO_SEAT` (`scr_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='좌석정보';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.SEATS 구조 내보내기
DROP TABLE IF EXISTS `SEATS`;
CREATE TABLE IF NOT EXISTS `SEATS` (
  `seats_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '좌석(다)코드',
  `pmt_code` int(11) NOT NULL COMMENT '결제코드',
  `seat_code` int(11) NOT NULL COMMENT '좌석코드',
  PRIMARY KEY (`seats_code`),
  KEY `FK_PAYMENT_TO_SEATS` (`pmt_code`),
  KEY `FK_SEAT_TO_SEATS` (`seat_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='좌석(다:다)';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 better4307.STILLCUTIMG 구조 내보내기
DROP TABLE IF EXISTS `STILLCUTIMG`;
CREATE TABLE IF NOT EXISTS `STILLCUTIMG` (
  `stcImg_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '이미지코드',
  `mov_code` int(11) NOT NULL COMMENT '영화코드',
  `stcImg_path` varchar(100) NOT NULL COMMENT '이미지경로',
  PRIMARY KEY (`stcImg_code`),
  KEY `FK_MOVIE_TO_STILLCUTIMG` (`mov_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='스틸컷이미지';

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
