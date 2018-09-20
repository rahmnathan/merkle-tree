package com.github.rahmnathan.spike;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class Executable {
    private static final Logger logger = Logger.getLogger(Executable.class.getName());

    public static void main(String[] args) throws Exception {
        Leaf leftLeaf = new Leaf("Name", "Value");
        Leaf rightLeaf = new Leaf("NameRight", "Value");
        Node leftNode = new Node(leftLeaf, rightLeaf);

        leftLeaf = new Leaf("NameRightNode", "Value");
        rightLeaf = new Leaf("as;ldkfj", "value");
        Node rightNode = new Node(leftLeaf, rightLeaf);

        Node parentRight = new Node(leftNode, rightNode);

        logger.info(new ObjectMapper().writeValueAsString(new Node(leftNode, parentRight)));
    }
}
