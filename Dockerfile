From openJdk:21
EXPOSE 8085
ADD target/Employee-Management-System.jar Employee-Management-System.jar
ENTRYPOINT ["java","-jar","Employee-Management-System.jar"]
