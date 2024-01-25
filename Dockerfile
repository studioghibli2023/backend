FROM tomcat

ADD app.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]
EXPOSE 8080
EXPOSE 80