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
- EC2 Public IPv4: `3.38.182.66`
- API Base URL: `http://3.38.182.66:8080`
- Health Check: `http://3.38.182.66:8080/actuator/health`

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
```


## Lv.3 제출

### S3 객체 업로드 화면
![[내일배움캠프] Lv.3-1.png](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20Lv.3-1.png)

### Presigned URL 접근 화면
![[내일배움캠프] Lv.3-2.png](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20Lv.3-2.png)

### IAM Role 접근 성공
![[내일배움캠프] Lv.3-3.jpg](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20Lv.3-3.jpg)

### URL 발급 시각과 만료 시각
#### 발급 일시: 2026-11-16 16:02:31 (KST)

#### 설정된 유효기간: 7일 (604,800초)

#### 설정 기준 만료 일시: 2026-11-23 16:02:31 (KST)

#### 생성 방식: AWS SDK for Java 2.x S3Presigner

#### 인증 방식: EC2 IAM Role (commerce-api-ssm-role)

#### .signatureDuration(Duration.ofDays(7))

### ※ EC2 IAM Role의 임시 자격 증명이 먼저 만료되면 Presigned URL도 설정된 7일보다 일찍 만료될 수 있습니다.

## Lv.4 제출

## Github Actions 성공
![[내일배움캠프] Lv.4-1.jpg](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20Lv.4-1.jpg)

![[내일배움캠프] Lv.4-2.jpg](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20Lv.4-2.jpg)

## EC2 터미널
![[내일배움캠프] Lv.4-3.jpg](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20Lv.4-3.jpg)


## Lv.5

### HTTPS 적용된 도메인 URL
https://api.conanquiz.com/actuator/health

### Target Group(대상 그룹) 이미지
![[내일배움캠프] Lv.5-2.jpg](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20Lv.5-2.jpg)

### 도메인 연결은 Route 53 대신 기존 보유 도메인(가비아)의 DNS에서 api 서브도메인 CNAME 레코드로 ALB에 연결했습니다.

## Lv.6

## CloudFront 이미지 URL

https://d3ghufnvr258ws.cloudfront.net/973b95c7-d777-42c3-b25a-f9d3266978ff.jpg

## 추가)
### 제출하고 실행된 에이타니의 피드백을 바탕으로 첨부

### 1. SSL/TLS 인증서가 연결되어 HTTPS(443) 리스너가 구성
![[내일배움캠프] HTTPS(443) 리스너.jpg](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20HTTPS%28443%29%20%EB%A6%AC%EC%8A%A4%EB%84%88.jpg)

### ALB HTTPS 및 ACM 인증서 설정

- **로드 밸런서:** `commerce-alb`
- **리스너 프로토콜:** HTTPS
- **리스너 포트:** 443
- **연결된 ACM 인증서 도메인:** `api.conanquiz.com`
- **기본 동작:** 대상 그룹으로 전달(Forward)
- **대상 그룹:** `commerce-api-tg`

HTTP 리스너 설정:
- **프로토콜:** HTTP
- **포트:** 80
- **기본 동작:** HTTPS 443으로 리다이렉트(Redirect)

HTTPS 접속 및 헬스 체크:
- `https://api.conanquiz.com/actuator/health`

ALB의 HTTPS(443) 리스너에 ACM 인증서를 연결하고 HTTP(80) 요청은 HTTPS(443)으로 리다이렉트하도록 구성했습니다.


### 2. dockerfile이 존재하고, 해당 이미지를 컨테이너로 실행한 결과
![[내일배움캠프] dockfile 존재와 실행결과.jpg](%5B%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84%5D%20dockfile%20%EC%A1%B4%EC%9E%AC%EC%99%80%20%EC%8B%A4%ED%96%89%EA%B2%B0%EA%B3%BC.jpg)

### 실행 명령:
- sudo docker ps

### 실행 결과:
- Image: luludocker2/sparta-aws:lv4
- Status: Up 14 hours
- Port: 8080:8080
- Container: sparta-aws-container