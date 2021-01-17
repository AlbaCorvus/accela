package com.cjmulcahy.accela.assessment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cjmulcahy.accela.assessment.configuration.AssessmentConfiguration;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AssessmentConfiguration.class);
        ConsoleUI consoleUi = applicationContext.getBean(ConsoleUI.class);
        consoleUi.startConsole();
        applicationContext.close();
        /*try (Scanner scanner = new Scanner(System.in)) {
            while (true) {

                console.showConsoleMenu();
                switch (console.listen(scanner)) {
                case 0:
                    applicationContext.close();
                    System.exit(0);
                case 1:
                    console.showCreatePersonMenu(scanner);
                    break;
                case 2:
                    console.showUpdatePersonMenu(scanner);
                    break;
                case 3:
                    console.showDeletionMenu(scanner);
                    break;
                case 4:
                    console.showCount();
                    break;
                case 5:
                    console.listPersons();
                    break;
                }
            }
        }*/
    }
}
