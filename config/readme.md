### compile
mvn install

### Execute
java -jar ./target/config-server-1.0.jar

### Check
http://localhost:8888/application/default/master

## Note
application.properties
application-development.properties -> http://localhost:8888/application/development
application-production.properties -> http://localhost:8888/application/production

http://localhost:8888/application/default
http://localhost:8888/application/master
http://localhost:8888/application/default/master
