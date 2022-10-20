
# 장소 검색 API를 활용한


## 프로젝트 설명
- 장소 검색 서비스를 위한 서버 프로그램을 구현
- API 테스트 방법: HTTP Request file 


## 개발 내용

### 기술 스택
- Spring Boot 2.6.12
- Spring Data JPA
- Java 11 버전
- Gradle 7.1.1
- h2 database
- lombok
- retrofit
  - 외부 REST API 사용이 쉽고, 기타 configuration 설정이 쉬움 
  - 외부 API 사용 시 프로젝트에서 필요한 객체(DTO)로 변환 용이


### 상세 구현 설명
- 테스트 주도 개발로, 변경 개발의 위험 최소화 
- OOP로, Spring의 Service 구현 로직 최소화
- Strategy Pattern 적용 
  - 검색 API 추가/삭제 시, 변경 개발 부분 최소화
- CQRS 패턴 적용으로, CUD(Command), R(Query) 분리
- 일급컬렉션(First Class Collection)
  - 컬렉션과 일반 객체의 비즈니스 로직 분리
- 원시값 포장
  - 도메인의 한 필드에 대한 비즈니스 로직 분리로, 각 객체의 코드 간소화


