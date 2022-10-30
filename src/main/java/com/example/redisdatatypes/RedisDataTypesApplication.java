package com.example.redisdatatypes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RedisDataTypesApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext run =
                SpringApplication.run(RedisDataTypesApplication.class, args);

        final RedisSortedSet redisSortedSet = run.getBean(RedisSortedSet.class);
        redisSortedSet.updateLeaderBord();

        final RedisGeospatial redisGeospatial = run.getBean(RedisGeospatial.class);
        redisGeospatial.add();

        final RedisHashes redisHashes = run.getBean(RedisHashes.class);
        redisHashes.set();

    }

}
