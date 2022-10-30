package com.example.redisdatatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class RedisGeospatial {

    private final RedisTemplate<String, String> redisTemplate;

    public void add() {
        final String key = "restaurant";
        final Double longitude = 41.0;
        final Double latitude = 29.0;

        Map<String, Point> kebaps = Map.of("Kebapçı", new Point(longitude, latitude));

        redisTemplate.opsForGeo().add(key, kebaps);

        // 1 km içerisindeki restoranları bul
        Circle circle = new Circle(longitude, latitude, 1);
        Objects.requireNonNull(redisTemplate.opsForGeo().radius(key, circle)).forEach(System.out::println);
    }
}
