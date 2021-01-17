Sample Java Project
This is a reference for setting up the Person CRUD console application. GitHUb project https://github.com/AlbaCorvus/accela.git

Setup
Import project from github using IDE of your choice run maven configuration base directory ${project_loc:assessment} Goals clean compile assembly:single use JUnit 4 dependency
In your target folder for the project workspace example C:\workspace\accela\assessment\target open a shell command and run the following

Or given that I have pushed the target folder you can just import the project and run the following from the target folder without building the project again.

java -cp assessment-0.0.1-SNAPSHOT-jar-with-dependencies.jar org.h2.tools.Console

This will open your browser window and launch the H2DB ~test database your credentials will be username "sa" and password "" by default please don not change these as applications persistence.xml refers to these credentials for DB connection.

After you hit connect button from h2 Console open another console window from target folder and run the following cmd

java -jar assessment-0.0.1-SNAPSHOT-jar-with-dependencies.jar

This will launch the application assessment from App.java class as main.

Dependencies

Spring Framework
org.h2
Java JRE 8 >

Work Notes

Addresses functionality limited as time constraints played a role, can edit addresses under update person option [2]
Can delete addresses by proxy through option [3] delete person.
Can add multiple addresses to person when creating in option [1]