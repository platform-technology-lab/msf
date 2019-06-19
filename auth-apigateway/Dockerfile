FROM openjdk:8-jre-alpine
ENV APP_FILE auth-apigateway-1.0.jar
ENV APP_HOME /usr/apps
EXPOSE 8066
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]
