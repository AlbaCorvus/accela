package com.cjmulcahy.accela.assessment;

import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.assessment.domain.Address;
import com.cjmulcahy.accela.assessment.domain.Person;
import com.cjmulcahy.accela.assessment.menu.Menu;
import com.cjmulcahy.accela.assessment.menu.MenuFactory;
import com.cjmulcahy.accela.assessment.service.PersonService;
import com.cjmulcahy.accela.assessment.utils.ScannerUtils;
import com.cjmulcahy.accela.assessment.utils.enums.MenuType;

public class ConsoleUI {

  
    
    @Autowired
    private MenuFactory menuFactory;

    public ConsoleUI() {
        
    }
    
    public void startConsole(){
        ScannerUtils scannerUtils = new ScannerUtils();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {

                Menu main = menuFactory.getMenu(MenuType.MAIN_MENU);
                main.display();
                switch (scannerUtils.listenForInt(scanner)) {
                case 0:
                    System.exit(0);
                case 1:
                    main.display(1);
                    break;
                case 2:
                    main.display(2);
                    break;
                case 3:
                    main.display(3);
                    break;
                case 4:
                    main.display(4);
                    break;
                case 5:
                    main.display(5);
                    break;
                case -1:
                    break;
                }
            }
        }
    }

}
