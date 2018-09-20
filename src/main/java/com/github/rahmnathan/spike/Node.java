package com.github.rahmnathan.spike;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {
    private final byte[] hash;
    private final Node left;
    private final Node right;

    public Node(byte[] hash) {
        this.hash = hash;
        this.left = null;
        this.right = null;
    }

    public Node(Node left, Node right) {
        this.hash = HashUtils.hash(left, right);
        this.left = left;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public byte[] getHash(){
        return hash;
    }
}
