FROM tomcat:8.5.82-jre8
COPY target/ownerapp*.war /usr/local/tomcat/webapps/ownerapp.war

