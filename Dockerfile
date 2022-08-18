FROM tomcat:latest
CMD mv /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps/
COPY target/ownerapp*.war /usr/local/tomcat/webapps/ownerapp.war

