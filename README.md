# Getting Started

## Installation of required sw

### open jdk
```sh
* sudo apt-get install openjdk-8-jdk
```
### git
```sh
* sudo apt-get install git
```
### maven
```sh
* sudo apt-get install maven
```
### docker
```sh
* sudo apt-get install docker.io
```
### curl
```sh
* sudo apt-get install curl
```
### docker-compose (Ubuntu 18.0.4)
```sh
1. sudo curl -L "https://github.com/docker/compose/releases/download/1.23.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
2. sudo chmod +x /usr/local/bin/docker-compose
3. (checkup) docker-compose --version
```
## Execution

### Local start (It takes a lot of time because the library needs initial download on first run)
```sh
./dev-run.sh
```

### Local stop
```sh
./dev-stop.sh
```

#### Read logs
```sh
sudo docker logs [docker service name]
* sudo docker logs employee
```

## Local Test URL

config: http://localhost:8888/application/master

EUREKA: http://localhost:8761

employee: http://localhost:8011/employees/

apigateway: http://localhost:8065/employee/employees/

auth-apigateway: http://localhost:8066/employee/employees/

basicexample: http://localhost:8012/employees

clientexample: http://localhost:8015/emplist

(It takes a lot of time to start up the services)

## Memo

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

* API-DOC
http://localhost:8011/swagger-ui.html

* minikube configuration
eval $(minikube docker-env)


Reference
Executing by docker command

sudo docker rm -f config
sudo docker run -d -p 8888:8888 --name config imich/config-server:v1

sudo docker rm -f eureka
sudo docker run -d -p 8761:8761 --link config --name eureka imich/eureka:v1

sudo docker rm -f employee
sudo docker run -d -p 8011:8011 --link config --link eureka --name employee imich/employee:v1
