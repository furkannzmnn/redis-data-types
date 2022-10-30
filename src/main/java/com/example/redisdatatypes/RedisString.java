package com.example.redisdatatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisString {

    // PERFORMANCE  O(1) -> BAZI METHODLAR HARİÇ


    private final RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "key:1";
    private static final String VALUE = "value";

    /*
    EN BASİT VERİ TÜRÜDÜR
    GENELLİKLE CACHE İÇİN KULLANILIR

    1. METHOD ŞUNU YAPAR

    1- SET key:1

    2. METHOD ŞUNU YAPAR
    1- GET key:1
     */

    public void set() {
        redisTemplate.opsForValue().set(KEY, VALUE);
    }

    // get
    public Object get() {
        return redisTemplate.opsForValue().get(KEY);
    }


    // JSON SAKLAMAK
    // EX REDİS COMMAND-WİTH TLL-> SSET user:furkan "\"{'username' : 'furkan', 'password' : 'furkanozmen' }\"" EX 100
    public void setJson() {
        String json = "{\"name\":\"ali\",\"surname\":\"veli\"}";
        redisTemplate.opsForValue().set(KEY, json);
    }

    // SETNX
    // SETNX key:1 value
    // bu methodu bir kez çalıştırdıktan sonra tekrar çalıştırdığımızda false döner
    public boolean setNx() {
       return Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(KEY, VALUE));
    }
}
