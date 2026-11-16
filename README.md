# Lv.0 요금 폭탄 방지 AWS Budget 설정
![[내일배움캠프] 클라우드 과제 Lv.0 -1.jpg](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C%20%EA%B3%BC%EC%A0%9C%20Lv.0%20-1.jpg)

![[내일배움캠프] 클라우드 과제 Lv.0 -2.jpg](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C%20%EA%B3%BC%EC%A0%9C%20Lv.0%20-2.jpg)

# Sparta-AWS

## LV.0 - 클라우드 과제
- 클라우드 및 AWS 기초 학습

## LV.1 - Spring Boot API 배포

### 1. AWS 인프라
- VPC: commerce-vpc
- Public Subnet: commerce-public-subnet
- Private Subnet: commerce-private-subnet
- Internet Gateway: commerce-igw
- EC2: t3.micro

### 2. 기술 스택
- Java 17
- Spring Boot 4.1.2
- Spring Data JPA
- H2 Database
- MySQL
- Spring Boot Actuator

### 3. API
| Method | Endpoint | 기능 |
|---|---|---|
| POST | /api/members | 회원 등록 |
| GET | /api/members/{id} | 회원 조회 |
| GET | /actuator/health | 서버 상태 확인 |

### 4. 배포 정보
- EC2 Public IPv4: `13.124.234.198`
- API Base URL: `http://13.124.234.198:8080`
- Health Check: `http://13.124.234.198:8080/actuator/health`

### 5. 실행 프로파일
- local: H2 Database
- prod: MySQL Database

## LV2 제출 정보

![[내일배움캠프] Lv.2.jpg](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20Lv.2.jpg)
### Actuator Info
- URL: http://13.124.234.198:8080/actuator/info

### 출력 결과
```json
{
  "team": {
    "name": "Sparta-AWS"
  }
}