sudo docker rm -f config
sudo docker run -d -p 8888:8888 --name config imich/config-server:v1

sudo docker rm -f eureka
sudo docker run -d -p 8761:8761 --link config --name eureka imich/eureka:v1

sudo docker rm -f employee
sudo docker run -d -p 8011:8011 --link config --link eureka --name employee imich/employee:v1
