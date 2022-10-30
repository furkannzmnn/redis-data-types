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
        final String member = "user1";
        final int score = 100;

        final String member2 = "user3";
        final int score2 = 200;

        final String member3 = "user2";
        final int score3 = 300;


        redisTemplate.opsForZSet().add(key, member, score);
        redisTemplate.opsForZSet().add(key, member2, score2);
        redisTemplate.opsForZSet().add(key, member3, score3);


        System.out.println(redisTemplate.opsForZSet().range(key, 0, 3));

        redisTemplate.opsForZSet().add(key, member3, score3 - 400);

        System.out.println(redisTemplate.opsForZSet().range(key, 0, 3));


        System.out.println(redisTemplate.opsForZSet().reverseRange(key, 0, 3));
    }
}
