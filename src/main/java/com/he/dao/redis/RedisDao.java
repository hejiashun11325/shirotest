package com.he.dao.redis;

import com.he.config.Global;
import com.he.redis.RedisManager;
import com.he.redis.SerializeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hejiashun
 * @Date: 2018/1/8
 * Description:redis方法封装
 */
@Service("redisDao")
public class RedisDao {

    @Autowired
    private RedisManager redisManager;

    /**
     * 获取对象
     * @param key
     * @return
     */
    public Object getSession(String key){
        return redisManager.get(key.getBytes());
    }

    /**
     * 保存数据
     * @param key
     * @param value
     */
    public void putSession(String key,Object value){
        redisManager.set(key.getBytes(), SerializeUtils.serialize(value));
    }

    /**
     * 保存数据设置有效时间
     * @param key
     * @param value
     * @param expire
     */
    public void putSessionAndTime(String key,Object value,int expire){
        redisManager.set(key.getBytes(),SerializeUtils.serialize(value) , expire);
    }
    /**
     * 保存字符串数据设置有效时间
     * @param key
     * @param value
     * @param expire
     */
    public void putStringAndTime(String key,String value,int expire){
        redisManager.set(key.getBytes(),value.getBytes() , expire);
    }
    /**
     * 获取字符串数据
     * @param key
     */
    public String getStringSession(String key){
        byte[] bytes = redisManager.get(key.getBytes());
        if(bytes!=null&&bytes.length>0){
            return new String(bytes);
        }
        return  null;
    }
}
