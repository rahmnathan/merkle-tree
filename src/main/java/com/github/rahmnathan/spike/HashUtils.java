package com.github.rahmnathan.spike;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HashUtils {
    private static final Logger logger = Logger.getLogger(HashUtils.class.getName());

    public static byte[] hash(String name, String value){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest((name + value).getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "Failure hashing leaf contents.", e);
            return null;
        }
    }

    public static byte[] hash(Node left, Node right){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if(left != null && left.getHash() != null){
                byteArrayOutputStream.write(left.getHash());
            }
            if (right != null && right.getHash() != null) {
                byteArrayOutputStream.write(right.getHash());
            }

            if(byteArrayOutputStream.size() != 0) {
                return digest.digest(byteArrayOutputStream.toByteArray());
            }

            return null;
        } catch (IOException | NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "Failure hashing node.", e);
            return null;
        }
    }
}
