package com.he.utils;


/**
 * @author: hejiashun
 * @Date: 2017/11/17
 * Description:
 */
public class StringUtil {

    public static boolean isNotBlank(String value){
        if(value==null||value.length()==0){
            return  false;
        }
        return true;
    }
}
