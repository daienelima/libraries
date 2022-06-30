package com.libraries.examples.utils;

public class StringsUtils {

    /**
     * insert left zeros
     * @param value
     * @param size
     * @return the value with zeros
     */
    public static String leftZeros(String value, int size){
        if(value.isBlank()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(value);
        for (int i = value.length(); i < size; i++){
            stringBuilder.insert(0,0);
        }
        return stringBuilder.toString();
    }
}
