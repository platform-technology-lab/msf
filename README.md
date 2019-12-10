# Getting Started

## 환경설정

### open jdk 설치
sudo apt-get install openjdk-8-jdk

### git 설치
sudo apt-get install git

### maven 설치
sudo apt-get install maven

### docker 설치
sudo apt-get install docker.io

### curl 설치
sudo apt-get install curl

### docker-compose 설치 (Ubuntu 18.0.4)
1. sudo curl -L "https://github.com/docker/compose/releases/download/1.23.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
2. sudo chmod +x /usr/local/bin/docker-compose
3. (설치확인) docker-compose --version

## 실행

### 로컬실행 (처음 실행시 라이브러리 초기 다운로드가 필요하여 많은 시간 소요)
./dev-run.sh

### 로컬정지
./dev-stop.sh

#### 로그보기
sudo docker logs 

## 로컬테스트

config: http://localhost:8888/application/master

EUREKA: http://localhost:8761

employee: http://localhost:8011/employees/

apigateway: http://localhost:8065/employee/employees/

auth-apigateway: http://localhost:8066/employee/employees/

basicexample: http://localhost:8012/employees

clientexample: http://localhost:8015/emplist

(실제로 서비스가 실행되어 페이지가 뜰때까지 시간이 소요될 수 있음)

## 메모

[Start] 
sudo docker-compose up -d --build

If a container exists after prior building, the docker compose doesn't rebuild it. So, [--build] option is necessary.

[Stop] 
sudo docker-compose down

[Log]
If you want to see logs,
 
sudo docker-compose logs [-f] [service name]

[-f] option shows logs continuously without terminating.



* Refresh method
curl localhost:8888/actuator/bus-refresh

* API-DOC 확인
http://localhost:8011/swagger-ui.html

* minikube 환경설정
eval $(minikube docker-env)


Reference
Executing by docker command

sudo docker rm -f config
sudo docker run -d -p 8888:8888 --name config imich/config-server:v1

sudo docker rm -f eureka
sudo docker run -d -p 8761:8761 --link config --name eureka imich/eureka:v1

sudo docker rm -f employee
sudo docker run -d -p 8011:8011 --link config --link eureka --name employee imich/employee:v1
