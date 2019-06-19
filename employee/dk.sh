mvn clean
mvn install
sudo docker rmi -f imich/employee:v1
sudo docker build . -t imich/employee:v1
