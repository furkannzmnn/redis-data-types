package com.example.redisdatatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisLists {

    /*
    1- Implement stacks and queues.
    2- Build queue management for background worker systems.
     */

    private final RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "user:1";
    private static final String VALUE = "furkan";


    // QUEUE TARZI -> first in, first out
    public void push() {
        redisTemplate.opsForList().leftPush(KEY, VALUE);
    }

    public void pop() {
        redisTemplate.opsForList().leftPop(KEY);
    }

    // STACK TARZI -> first in, last out
    public void pushStack() {
        redisTemplate.opsForList().rightPush(KEY, VALUE);
    }

    // Blocking commands
    // 1- BLPOP
    public void popStack() {
        redisTemplate.opsForList().rightPop(KEY);
    }
}
