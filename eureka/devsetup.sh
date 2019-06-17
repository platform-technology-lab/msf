mvn clean
mvn install
sudo docker rmi -f imich/eureka:v1
sudo docker build . -t imich/eureka:v1
