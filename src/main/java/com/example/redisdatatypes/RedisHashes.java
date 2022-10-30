package com.example.redisdatatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisHashes {

    // PERFORMANCE  O(1) -> BAZI METHODLAR HARİÇ
    // EX VİDEO : https://www.youtube.com/watch?v=-KdITaRkQ-U&ab_channel=Redis

    private final RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "key:1";
    private static final String FIELD_1 = "username";
    private static final String FIELD_2 = "password";
    private static final String VALUE = "furkan";

    /*
    redis key-value yapısında keylerin içindeki fieldlara erişmek için kullanılır

    REDİ COMMAND -> HSET key:1 username furkan password furkan
     */
    public void set() {
        redisTemplate.opsForHash().put(KEY, FIELD_1, VALUE);
        redisTemplate.opsForHash().put(KEY, FIELD_2, VALUE);
    }

    // REDİS COMMAND -> HGET key:1 username
    public Object get() {
        return redisTemplate.opsForHash().get(KEY, FIELD_1);
    }

    // REDİS COMMAND -> HGETALL key:1
    public Object getAll() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    // REDİS COMMAND -> HDEL key:1 username
    public void delete() {
        redisTemplate.opsForHash().delete(KEY, FIELD_1);
    }

}
