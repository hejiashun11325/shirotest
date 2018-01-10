package com.he.utils;

import java.util.List;

/**
 * @author: hejiashun
 * @Date: 2018/1/8
 * Description:队列工具类
 */
public class CollectionUtil {
    /**
     * 判断队列是否为空或者长度为0
     * @param list
     * @return
     */
    public static boolean isListNullOrZero(List list){
        if(list==null){
            return true;
        }
        if(list.size()==0){
            return true;
        }
        return false;
    }
}
