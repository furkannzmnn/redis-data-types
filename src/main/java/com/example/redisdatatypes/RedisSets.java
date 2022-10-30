package com.example.redisdatatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class RedisSets {

    // EKLEME ÇIKARMA İŞLEMLERİ O(1)'DİR. ANCAK SMEMBERS KULLANIRKEN DİKKATLİ OLMAK GEREK. YÜZ BİNLERCE
    // VERİNİN SAKLANDIĞI ORTAMDA O(N) ÇÖZÜM SUNAR

    private final RedisTemplate<String, String> redisTemplate;

    // Add a member to a set
    /*
    use cases:
    - Track unique items
    - Track unique visitors
    - Represent relations (e.g., the set of all users with a given role).
     */
    public void add() {
        final String userKey = "user:1";
        final String userFriends = "furkan";

        final String userKey2 = "user:2";
        final String userFriends2 = "furkan";

        redisTemplate.opsForSet().add(userKey, userFriends);
        redisTemplate.opsForSet().add(userKey2, userFriends2);

        boolean isMember = Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(userKey, userFriends));
        System.out.println("isMember = " + isMember);

        boolean isMember2 = Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(userKey2, userFriends2));
        System.out.println("isMember2 = " + isMember2);

        // user1 ve user2 aynı arkadaşlara sahip mi ? -> SINTER user1 user2
        Long size = redisTemplate.opsForSet().intersectAndStore(userKey, userKey2, "commonFriends");
        System.out.println("size = " + size);

        Objects.requireNonNull(redisTemplate.opsForSet().intersect(userKey, userKey2)).forEach(System.out::println);

    }




}
