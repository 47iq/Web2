package com.example.web2.model;

import java.util.*;
import java.util.stream.Collectors;

public class Results {
    private final Deque<Point> pointDeque;

    public Results() {
        pointDeque = new ArrayDeque<>();
    }

    public void add(Point point) {
        int MAX_SIZE = 10;
        if(pointDeque.size() > MAX_SIZE)
            pointDeque.pollFirst();
        pointDeque.addLast(point);
    }

    public List<Point> getPoints() {
        return pointDeque.stream().sorted((x, y) -> (-1) * x.compareTo(y)).collect(Collectors.toList());
    }
}
