package com.example.redisdatatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisSortedSet {

    private final RedisTemplate<String, String> redisTemplate;

    // Add a member to a sorted set, or update its score if it already exists
    /*
    use cases:
    - Leaderboard
    - Ranking
    - Ranking with scores
     */

    public void updateLeaderBord() {
        final String key = "leaderboard:455";
        final String member = "furkan";
        final Double score = 100.0;

        final String member2 = "furkan2";
        final Double score2 = 200.0;

        final String member3 = "furkan3";
        final Double score3 = 300.0;


        redisTemplate.opsForZSet().add(key, member, score);
        redisTemplate.opsForZSet().add(key, member2, score2);
        redisTemplate.opsForZSet().add(key, member3, score3);

        // 1. sıradaki kullanıcı
        System.out.println("1. sıradaki kullanıcı = " + redisTemplate.opsForZSet().range(key, 0, 3));
    }
}
