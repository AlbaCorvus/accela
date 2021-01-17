package com.cjmulcahy.accela.assessment.utils.enums;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum MenuType {

    MAIN_MENU(0),CREATE_PERSON_MENU(1), UPDATE_PERSON__MENU(2), DELETE_PERSON_MENU(3), COUNT_MENU(4),LIST_PERSON_MENU(5) , FIND_PERSON_BY_ID_MENU(6);
    
    private int selection;
    
    private static final Map<Integer,MenuType> ENUM_MAP;
    
    private MenuType(int selection){
        this.selection = selection;
    }
    
    public int getSelection(){
        return selection;
    }
    
    static {
        Map<Integer,MenuType> map = new ConcurrentHashMap<Integer,MenuType>();
        for (MenuType instance : MenuType.values()) {
            map.put(instance.getSelection(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static MenuType getMenuType (int selection) {
        return ENUM_MAP.get(selection);
    }
}
