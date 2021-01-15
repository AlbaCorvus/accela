Sample Java Project
This is a reference for setting up the Person CRUD console application. GitHUb project https://github.com/AlbaCorvus/accela.git

Setup
Import project from github using IDE of your choice run maven configuration base directory ${project_loc:assessment} Goals clean compile assembly:single use JUnit 4 dependency
In your target folder for the project workspace example C:\workspace\accela\assessment\target open a shell command and run the following

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
There is no validation on the input console menu at all :(
Please choose from the numeric options given by the console menus.