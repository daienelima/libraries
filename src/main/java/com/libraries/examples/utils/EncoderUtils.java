package com.libraries.examples.utils;

import java.util.Base64;

public class EncoderUtils {

    public static String generatedEncoder(String key){
        if(key.isBlank()){
            return "";
        }
        return Base64.getEncoder().encodeToString(key.getBytes());
    }
}
