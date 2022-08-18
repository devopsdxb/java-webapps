FROM tomcat:latest
COPY target/ownerapp*.war /usr/local/tomcat/webapps/ownerapp.war

