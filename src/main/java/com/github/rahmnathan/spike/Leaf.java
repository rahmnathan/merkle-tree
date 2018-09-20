package com.github.rahmnathan.spike;

import static com.github.rahmnathan.spike.HashUtils.hash;

public class Leaf extends Node {
    private final String name;
    private final String value;

    public Leaf(String name, String value) {
        super(hash(name, value));
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
