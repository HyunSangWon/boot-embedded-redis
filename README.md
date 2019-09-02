Spring Boot Embedded Redis
=============

개요 : 내장 레디스를 통한 개발테스트 환경 구축
-------------

### What is Redis?  
레디스는 인메모리 NO-SQL 데이터베이스(안드로이드에 SQL라이트와 같음), KEY-VALUE로 이루어져 있다.  
N0-SQL은 데이터 간의 관계보단 고정된 스키마를 주로 갖는 환경에 적합.
레디스는 JVM위에서 동작하지 않고, GC 대상이 아니여서 오버헤드가 줄어드는 장점이 있고, 특정 데이터 캐싱도 가능.  
AWS와 같은 클라우드 환경에서는 멀티캐스트 기능이 없기에 세션클러스터링을 할 수 가없음.  
클라우드 환경을 고려해 세션공유는 레디스를 사용하는게 맞는것 같음!  

### 개발 환경 (19-09-02)  
***버전 없는 항목은 해당날짜에 맞는 최신버전***  

Spring Boot 2.1.7 v  
embedded-redis 0.7.2 v
spring-boot-starter-data-redis  
lombok  

### Project Structure  

+ RedisController (REST save기능과 find 기능만 있음)  
+ StudentService (StudentRepository를 구현,hashOperations 사용)  
+ EmbeddedRedisConfig (profile이 dev인 것만 사용)    
+ RedisRepositoryConfig (실제 Redis 연동 부분)  

### 참고 자료  
http://arahansa.github.io/docs_spring/redis.html (Redis 정리 잘함)  
https://jistol.github.io/java/2017/09/15/tomcat-clustering/ (톰캣 세션클러스터링 한계)  
https://jojoldu.tistory.com/297 (소스 참고)
