package com.drive.utils;


public class SQLUtils {
    public static String PreparedStatement(String statement, Object ...args){
        StringBuilder sb = new StringBuilder(statement); 
        for(Object arg : args){
            int index = sb.indexOf("?"); 
            if(index == -1){
                break ; 
            }
            sb.replace(index, index+1, arg.toString()); 
        }

        return sb.toString(); 
    }
}
