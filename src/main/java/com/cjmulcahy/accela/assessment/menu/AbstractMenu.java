package com.cjmulcahy.accela.assessment.menu;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.assessment.utils.ScannerUtils;

public class AbstractMenu implements Menu{
    
    @Autowired
    protected Scanner scanner;

    @Autowired
    protected ScannerUtils scannerUtils;

    @Autowired
    protected MenuFactory menuFactory;
    
    protected AbstractMenu(){
        
    }

    
    @Override
    public void display() {
        
    }

    @Override
    public void display(int selection) {
        
    }

    @Override
    public void takeInputAction() {
        
    }

}
