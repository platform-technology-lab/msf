mvn clean
mvn install
sudo docker rmi -f imich/config-server:v1
sudo docker build . -t imich/config-server:v1
