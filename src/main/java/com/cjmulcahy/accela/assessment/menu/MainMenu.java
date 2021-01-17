package com.cjmulcahy.accela.assessment.menu;


import org.springframework.stereotype.Component;

import com.cjmulcahy.accela.assessment.utils.enums.MenuType;

@Component
public class MainMenu extends AbstractMenu{

    
    @Override
    public void display() {
        System.out.println("****************************************");
        System.out.println("1.) Create Person [Press 1]");
        System.out.println("2.) Update Person [Press 2]");
        System.out.println("3.) Delete Person [Press 3]");
        System.out.println("4.) Count People [Press 4]");
        System.out.println("5.) List People [Press 5]");
        System.out.println("6.) Exit [Press 0]");
        System.out.println("*****************************************");
    }

    @Override
    public void display(int selection) {
        Menu menu = menuFactory.getMenu(MenuType.getMenuType(selection));
            menu.display();
           menu.display(scannerUtils.listenForAnyInt(scanner));
           menu.takeInputAction();
    }

    @Override
    public void takeInputAction() {
        
        
    }

}
