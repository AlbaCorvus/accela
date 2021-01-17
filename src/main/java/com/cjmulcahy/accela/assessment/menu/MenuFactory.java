package com.cjmulcahy.accela.assessment.menu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjmulcahy.accela.assessment.utils.enums.MenuType;


@Component
public class MenuFactory {
    
    @Autowired
    private MainMenu mainMenu;
    @Autowired
    private CreatePersonMenu createPersonMenu;
    @Autowired
    private DeletePersonMenu deletePersonMenu;
    @Autowired
    private CountPersonMenu findPersonMenu ;
    @Autowired
    private ListPersonMenu listPersonMenu;
    @Autowired
    private UpdatePersonMenu updatePersonMenu;
    @Autowired
    private CountPersonMenu countPersonMenu;
    

    public Menu getMenu(MenuType menuType){
        switch(menuType){
        case MAIN_MENU:
            return mainMenu;
        case CREATE_PERSON_MENU:
            return createPersonMenu;
        case DELETE_PERSON_MENU:
            return deletePersonMenu;
        case COUNT_MENU:
            return countPersonMenu;
        case FIND_PERSON_BY_ID_MENU:
            return findPersonMenu;
        case LIST_PERSON_MENU:
            return listPersonMenu;
        case UPDATE_PERSON__MENU:
            return updatePersonMenu;
            default:
                throw new RuntimeException("Menu option not available");
        }
        
    }
    
}
