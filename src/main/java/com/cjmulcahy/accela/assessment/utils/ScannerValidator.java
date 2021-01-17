package com.cjmulcahy.accela.assessment.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerValidator {

    public static int validateAndReturn(Scanner scanner){
        int scannerInt = -1;
        try{
            if(scanner.hasNextInt()){
            scannerInt = scanner.nextInt();
            scanner.nextLine();
            if(scannerInt > 5 || scannerInt < 0){
                throw new InputMismatchException();
            }
            }else{
                scanner.next();
                throw new InputMismatchException();
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input detected, please try again");
        }
        
        return scannerInt;
    }
    
    public static String validateStringAndReturn(Scanner scanner){
        if(!scanner.hasNextLine()){
            throw new RuntimeException("Invalid input for String");
        }else{
            return scanner.nextLine();
        }
    }
    
    public static int validateIntegerWithRange(Scanner scanner, int lower, int higher){
        int scannerInt = -1;
        try{
            if(scanner.hasNextInt()){
            scannerInt = scanner.nextInt();
            scanner.nextLine();
            if(scannerInt > higher || scannerInt < lower){
                throw new InputMismatchException();
            }
            }else{
                scanner.next();
                throw new InputMismatchException();
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input detected, please try again");
        }
        
        return scannerInt;
    }

    public static int validateInteger(Scanner scanner) {
        try{
            if(scanner.hasNextInt()){
                int nextInt = scanner.nextInt();
                scanner.nextLine();
                return nextInt;
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input detected, please try again");
        }
        return -1;
    }
    
}
