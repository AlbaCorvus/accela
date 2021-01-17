package com.cjmulcahy.accela.assessment.utils;

import java.util.Scanner;

public class ScannerUtils {

    public int listenForInt(Scanner scanner){
        return ScannerValidator.validateAndReturn(scanner);
    }
    
    public String listenForString(Scanner scanner){
        return ScannerValidator.validateStringAndReturn(scanner);
    }

    public int listenForAnyInt(Scanner scanner) {
        return ScannerValidator.validateInteger(scanner);
    }
    
    public int listenForIntegerWithRange(Scanner scanner,int lower, int higher){
        return ScannerValidator.validateIntegerWithRange(scanner, lower, higher);
    }
    
}
