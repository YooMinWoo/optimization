# Spring Boot Redis Cache Performance Optimization

이 프로젝트는 `Spring Boot`, `Redis`, `JPA`, `QueryDSL`을 활용하여 **DB 조회 성능을 최적화**하는 예제입니다.  
`JMeter`를 사용해 **캐시 적용 전/후 성능 차이** 및 **동시 요청 처리 능력**을 비교했습니다.

---

## 🛠️ 사용 기술 스택

- **Java 17**
- **Spring Boot 3.x**
- **JPA (Hibernate)**
- **QueryDSL 5**
- **MySQL 8**
- **Redis (Spring Data Redis)**
- **JMeter (성능 테스트 도구)**

---

## ⚙️ 기능 요약

- 게시글 조회 API 개발
    캐싱 전 (`GET /api/orders`)
    캐싱 후 (`GET /api/orders-cache`)
- 해당 API 응답에 대해 Redis 캐시 적용 (`@Cacheable`)
- 캐시 만료 시간 설정: 10분 (`TTL`)
- JMeter를 통한 성능 테스트

---

## 🚀 성능 테스트 결과

### ✅ 1. 단일 요청을 10번 반복

| 구분         | 평균 응답 시간(ms) |
|--------------|-------------------|
| **캐시 적용 전** | 800~850             |
| **캐시 적용 후** | 8~12               |

> 📌 **약 100배의 성능 향상** 확인
![Image](https://github.com/user-attachments/assets/5800a554-7736-49b8-a3e6-7f8058e70d10)
![Image](https://github.com/user-attachments/assets/7a4d6ca8-407a-4c16-9778-2403f3ba3490)
---

### ✅ 2. 동시 요청 100개 (스레드 수: 100, 루프 수: 1)

| 구분         | 평균 응답 시간(ms) |
|--------------|-------------------|
| **캐시 적용 전** | 12309             |
| **캐시 적용 후** | 3               |

> ⚡ **동시성 처리에서도 큰 차이 발생** – DB 부하 감소
![Image](https://github.com/user-attachments/assets/125a316b-ba7e-4c55-8769-5749459d078e)
![Image](https://github.com/user-attachments/assets/55fbad40-350c-4a98-af65-8aef12b949f3)
---

