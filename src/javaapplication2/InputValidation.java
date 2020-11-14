/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author HP
 */
public class InputValidation {
    private static final int INTEGER = 1;
    private int dataType;
    private boolean valid = false;
    
    public InputValidation(int dataType, boolean valid) {
        this.dataType = dataType;
        this.valid = valid;
    }
    
    public String getMessage() {
        String message = null;
        if(valid == false) {
            message = filterMessageType(this.dataType);
        }
        return message;
    }
    
    private String filterMessageType(int dataType) {
        String message;
        switch(dataType) {
            case 1: 
                message = "Not an integer";
                break;
            default:
                message = "Not supported yet";
                break;
        }
        return message;
    }
    
    public static InputValidation isInteger(String input) {
        int dataType = INTEGER;
        boolean valid = false;
        try {
            int value = Integer.valueOf(input);
            valid = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new InputValidation(dataType, valid);
    }

    
     public static void main(String []args){
        String input = "abc";
        String result = InputValidation.isInteger(input).getMessage();
        System.out.println(result);
     }
}