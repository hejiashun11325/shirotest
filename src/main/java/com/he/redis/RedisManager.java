package com.he.redis;


import com.he.config.Global;
import com.he.utils.StringUtil;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


import java.util.Set;

/**
 * 负责封装redispool最基础方法
 */
@Service("redisManager")
public class RedisManager {
	


	private static JedisPool jedisPool= (JedisPool) new FileSystemXmlApplicationContext("classpath:spring-context-jedis.xml").getBean("jedisPool");

	/**
	 * 初始化方法
	 */
//	public void init(){
//		if(jedisPool == null){
//			if(StringUtil.isNotBlank(Global.getConfig("password")) ){
//				jedisPool = new JedisPool(new JedisPoolConfig(), Global.getConfig("host"), Integer.parseInt(Global.getConfig("port")), Integer.parseInt(Global.getConfig("timeout")), Global.getConfig("password"));
//			}else if(Integer.parseInt(Global.getConfig("timeout")) != 0){
//				jedisPool = new JedisPool(new JedisPoolConfig(), Global.getConfig("host"), Integer.parseInt(Global.getConfig("port")),Integer.parseInt(Global.getConfig("timeout")));
//			}else{
//				jedisPool = new JedisPool(new JedisPoolConfig(), Global.getConfig("host"), Integer.parseInt(Global.getConfig("port")));
//			}
//		}
//	}

	
	/**
	 * get value from redis
	 * @param key
	 * @return
	 */
	public byte[] get(byte[] key){
		byte[] value = null;
		Jedis jedis = jedisPool.getResource();
		try{
			value = jedis.get(key);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return value;
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @return
	 */
	public byte[] set(byte[] key,byte[] value){
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.set(key,value);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return value;
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public byte[] set(byte[] key,byte[] value,int expire){
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.set(key,value);
			if(expire != 0){
				jedis.expire(key, expire);
		 	}
		}finally{
			jedisPool.returnResource(jedis);
		}
		return value;
	}
	
	/**
	 * del
	 * @param key
	 */
	public void del(byte[] key){
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.del(key);
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * flush
	 */
	public void flushDB(){
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.flushDB();
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * size
	 */
	public Long dbSize(){
		Long dbSize = 0L;
		Jedis jedis = jedisPool.getResource();
		try{
			dbSize = jedis.dbSize();
		}finally{
			jedisPool.returnResource(jedis);
		}
		return dbSize;
	}

	/**
	 * keys
	 * @param pattern
	 * @return
	 */
	public Set<byte[]> keys(String pattern){
		Set<byte[]> keys = null;
		Jedis jedis = jedisPool.getResource();
		try{
			keys = jedis.keys(pattern.getBytes());
		}finally{
			jedisPool.returnResource(jedis);
		}
		return keys;
	}
	
}
